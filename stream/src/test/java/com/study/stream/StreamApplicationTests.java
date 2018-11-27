package com.study.stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class StreamApplicationTests {

    @Autowired
    private MessageChannel messageChannel;

    @Test
    public void contextLoads() {
//        sinkSender.output().send(MessageBuilder.withPayload("From SinkSender!!").build());
        messageChannel.send(MessageBuilder.withPayload("From messageChannel").build());
    }

}
