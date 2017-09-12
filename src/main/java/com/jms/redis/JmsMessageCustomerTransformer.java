package com.jms.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.integration.transformer.Transformer;
import org.springframework.messaging.Message;

/**
 * Created by shiwx on 2017/4/25.
 */
public class JmsMessageCustomerTransformer implements Transformer {

    private static final Log LOG = LogFactory.getLog(JmsMessageCustomerTransformer.class);

    @Override
    public Message<?> transform(Message<?> message) {
        //不做任何事,原样返回
//        LOG.debug("message: " + message);
        return message;
    }

}
