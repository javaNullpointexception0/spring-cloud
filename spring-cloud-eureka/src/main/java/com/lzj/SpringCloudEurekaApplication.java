package com.lzj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //启用EurekaServer，表示该应用是一个EurekaServer
public class SpringCloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaApplication.class, args);
    }

}
