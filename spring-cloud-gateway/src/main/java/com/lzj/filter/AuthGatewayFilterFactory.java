package com.lzj.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

@Component
public class AuthGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthGatewayFilterFactory.Config> {

    public AuthGatewayFilterFactory() {
        super(Config.class);
    }

    //过滤器主体业务逻辑
    @Override
    public GatewayFilter apply(Config config) {
       return (exchange, chain) -> {
            String authorization = exchange.getRequest().getHeaders().getFirst("Authorizaion");
            if (!StringUtils.isEmpty(authorization) && "zhangsan".equals(authorization)) {
                //合法用户,继续放行
                return chain.filter(exchange);
            }
            //不合法，返回异常信息
           ServerHttpResponse response = exchange.getResponse();
            //设置header
           HttpHeaders headers = response.getHeaders();
           headers.add("Content-Type", "application/json;charset=UTF-8");
           //设置body
           String warningStr = "未登录或登录超时";
           DataBuffer buffer = response.bufferFactory().wrap(warningStr.getBytes());

           return response.writeWith(Mono.just(buffer));
       };
    }

    public static class Config {
        //这在初始化自己的配置信息
    }
}
