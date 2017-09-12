package com.jms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * Created by shiwx on 2017/4/24.
 */
@Component("queueDelegateListener")
public class QueueDelegateListener {

    private static final Log LOG = LogFactory.getLog(QueueDelegateListener.class);

    public void handleMessage(String message) {
        LOG.error("[onMessage]: " + message);
    }

}
