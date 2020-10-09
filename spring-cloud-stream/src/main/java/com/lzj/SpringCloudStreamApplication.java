package com.lzj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

@SpringBootApplication
@EnableBinding(value = {Source.class, Sink.class})
public class SpringCloudStreamApplication {

    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext context = SpringApplication.run(SpringCloudStreamApplication.class, args);

        //消息发送端
        Source source = context.getBean(Source.class);
        Message<String> message = MessageBuilder.withPayload("我发送了一条消息")
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build();
        boolean success = true;//source.output().send(message);
        //等待消息发送完成
        Thread.sleep(65000L);
        System.out.print("消息发送完成，发送结果：" + success);
    }
}
