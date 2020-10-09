package com.lzj;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class StreamConsumer {

    //消息接收端
    @StreamListener(Sink.INPUT)
    public void consumerMessage(Message<String> message) {
        System.out.println("接收到消息：" + message.getPayload().toString());
    }
}
