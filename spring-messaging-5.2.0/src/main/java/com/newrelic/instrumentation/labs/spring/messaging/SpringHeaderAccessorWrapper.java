package com.newrelic.instrumentation.labs.spring.messaging;

import com.newrelic.api.agent.HeaderType;
import com.newrelic.api.agent.Headers;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageHeaderAccessor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SpringHeaderAccessorWrapper implements Headers {

    private final MessageHeaderAccessor accessor;

    public SpringHeaderAccessorWrapper(MessageHeaderAccessor accessor) {
        this.accessor = accessor;
    }

    @Override
    public HeaderType getHeaderType() {
        return HeaderType.MESSAGE;
    }

    @Override
    public String getHeader(String name) {
        Object header = accessor.getHeader(name);
        return header instanceof String ? (String) header : null;
    }

    @Override
    public Collection<String> getHeaders(String name) {
        List<String> headers = new ArrayList<>();
        String value = getHeader(name);
        if (value != null) {
            headers.add(value);
        }
        return headers;
    }

    @Override
    public void setHeader(String name, String value) {
        accessor.setHeader(name, value);
    }

    @Override
    public void addHeader(String name, String value) {
        accessor.setHeader(name, value);

    }

    @Override
    public Collection<String> getHeaderNames() {
        MessageHeaders msgHeaders = accessor.getMessageHeaders();
        return msgHeaders != null ? msgHeaders.keySet() : Collections.emptyList();
    }

    @Override
    public boolean containsHeader(String name) {
        return getHeaderNames().contains(name);
    }
}
