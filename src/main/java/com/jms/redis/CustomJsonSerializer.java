package com.jms.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.integration.mapping.InboundMessageMapper;
import org.springframework.integration.support.json.Jackson2JsonMessageParser;
import org.springframework.integration.support.json.JsonInboundMessageMapper;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

/**
 * Created by shiwx on 2017/4/26.
 */
public class CustomJsonSerializer implements RedisSerializer<Message<?>> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final InboundMessageMapper<String> mapper = new JsonInboundMessageMapper(String.class, new Jackson2JsonMessageParser());

    @Override
    public byte[] serialize(Message<?> message) throws SerializationException {
        try {
            return this.objectMapper.writeValueAsBytes(message);
        }
        catch (JsonProcessingException e) {
            throw new SerializationException(e.getMessage(), e);
        }
    }

    @Override
    public Message<?> deserialize(byte[] bytes) throws SerializationException {
        try {
            final String content = new String(bytes);
            return new Message() {
                @Override
                public Object getPayload() {
                    return content;
                }

                @Override
                public MessageHeaders getHeaders() {
                    return null;
                }
            };
        }
        catch (Exception e) {
            throw new SerializationException(e.getMessage(), e);
        }
    }

}
