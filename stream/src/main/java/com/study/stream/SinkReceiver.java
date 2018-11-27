package com.study.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author qili.hu
 * @date 2018/11/27 11:36
 */
@EnableBinding(value = {Sink.class, SinkSender.class })
public class SinkReceiver {

    private static Logger logger = LoggerFactory.getLogger(StreamApplication.class);

    @StreamListener(Sink.INPUT)
    public void receive(Object payload) {
        logger.info("Received: "+payload);
    }
}
