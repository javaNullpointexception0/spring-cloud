package com.lzj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class MessageProducer {

    @Bean
    public MessageChannel initMessageChannel() {
        return new DirectChannel();
    }


}
