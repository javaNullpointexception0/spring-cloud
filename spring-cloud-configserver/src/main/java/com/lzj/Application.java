package com.lzj;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @datetime: 2018年9月2日 下午2:52:56
 * @author: luzhenjang
 * @description: 配置中心服务器端
 */
@SpringBootApplication
@EnableConfigServer  //开启注册中心服务端功能
@EnableDiscoveryClient
public class Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(WebApplicationType.SERVLET).run(args);
	}
}
