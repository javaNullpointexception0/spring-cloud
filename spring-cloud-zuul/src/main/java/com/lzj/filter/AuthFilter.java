package com.lzj.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;
import javax.servlet.http.HttpServletRequest;

@Component
public class AuthFilter extends ZuulFilter {

    @Override
    public String filterType() {
        //因为在路由前进行权限校验，所以该过滤器为前置过滤器
        return "pre";
    }

    @Override
    public int filterOrder() {
        //因为zuul会有默认的过滤器，所以这里的顺序应该在默认过滤器之后，数值越，越后执行
        return 6;
    }

    @Override
    public boolean shouldFilter() {
        //是否要执行该过滤器
        //按照权限验证逻辑，如果访问的是登录接口，应该不执行该过滤器，如果是非登录请求，应该都要执行该过滤器
        RequestContext ctx = RequestContext.getCurrentContext();
        //获取访问的路径
        String url = ctx.getRequest().getRequestURI();
        if (url.contains("login")) {
            //登录接口，不执行该过滤器，直接放行
            return false;
        }
        //其余情况都执行该过滤器
        return true;
    }

    //过滤器的核心逻辑
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String authorization = request.getHeader("Authorization");
        if (StringUtils.isEmpty(authorization) || !"zhangsan".equals(authorization)) {
            //验证不通过，禁止访问
            //forbbiden();
        }
        return null;
    }

    private void forbbiden() {
        RequestContext.getCurrentContext().setResponseStatusCode(HttpStatus.SC_FORBIDDEN);
        //重新抛出异常，待异常处理器处理，这里可以自定义异常，以标识是身份验证失败异常，方便后续异常处理逻辑判断
        ReflectionUtils.rethrowRuntimeException(new ZuulException("无访问权限", HttpStatus.SC_FORBIDDEN, "身份验证不通过"));
    }
}
