package com.jms.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

/**
 * Created by shiwx on 2017/4/24.
 */
public class JmsMessage1Handler implements MessageHandler {

    private static final Log LOG = LogFactory.getLog(JmsMessage1Handler.class);

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        LOG.debug("[handleMessage]: " + message.getPayload());
    }
}
