package com.lzj.filter;

import com.netflix.zuul.context.RequestContext;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

@Component
public class SendErrorRestFilter extends SendErrorFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            Throwable throwable = ctx.getThrowable();
            String status = String.valueOf(ctx.getResponseStatusCode());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", "异常码：" + status);
            jsonObject.put("errorMessage", throwable.getMessage());

            //记录日志...

            //发送响应
            ctx.setResponseBody(jsonObject.toString());
            ctx.getResponse().setContentType("text/html;charset=UTF-8");
            ctx.remove("throwable");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
