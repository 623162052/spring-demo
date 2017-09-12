package com.jms.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

/**
 * Created by shiwx on 2017/4/25.
 */
@Component
public class JmsMessage2Handler implements MessageHandler {

    private static final Log LOG = LogFactory.getLog(JmsMessage2Handler.class);

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        LOG.debug("[handleMessage]: " + message.getPayload());
    }
}
