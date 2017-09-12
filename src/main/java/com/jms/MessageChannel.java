package com.jms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;

/**
 * Created by shiwx on 2017/4/24.
 */
public class MessageChannel {
    private static final Log LOG = LogFactory.getLog(MessageChannel.class);


    @Autowired
    QueueChannel receiveChannel;

    public void getMsg(){
        Message<String> message = (Message<String>) receiveChannel.receive(0);
        LOG.debug("message: " + message.toString());
    }

}
