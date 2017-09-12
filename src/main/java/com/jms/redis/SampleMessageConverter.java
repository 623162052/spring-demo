package com.jms.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.MessageConverter;

/**
 * Created by shiwx on 2017/4/24.
 */
public class SampleMessageConverter implements MessageConverter {

    private static final Log LOG = LogFactory.getLog(SampleMessageConverter.class);

    @Override
    public Object fromMessage(Message<?> message, Class<?> aClass) {
        LOG.debug(message.toString());

        return message;
    }

    @Override
    public Message<?> toMessage(Object o, MessageHeaders messageHeaders) {
        LOG.debug(o.toString());
        return null;
    }
}
