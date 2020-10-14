package com.lzj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@Enable
public class SpringCloudProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderApplication.class, args);
    }

}
