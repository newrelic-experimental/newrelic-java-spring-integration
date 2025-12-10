package com.newrelic.instrumentation.labs.spring.integration;

import com.newrelic.api.agent.HeaderType;
import com.newrelic.api.agent.Headers;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SpringMessageHeaders implements Headers {

    private Message<?> message;

    public SpringMessageHeaders(Message<?> message) {
        this.message = message;
    }

    @Override
    public HeaderType getHeaderType() {
        return HeaderType.MESSAGE;
    }

    @Override
    public String getHeader(String name) {
        MessageHeaders headers = message.getHeaders();
        Object value = headers.get(name);
        return value == null ? null : value.toString();
    }

    @Override
    public Collection<String> getHeaders(String name) {
        List<String> headers = new ArrayList<>();
        String value = getHeader(name);
        if(value != null) {
            headers.add(value);
        }
        return headers;
    }

    @Override
    public void setHeader(String name, String value) {

    }

    @Override
    public void addHeader(String name, String value) {

    }

    @Override
    public Collection<String> getHeaderNames() {
        MessageHeaders headers = message.getHeaders();

        return headers.keySet();
    }

    @Override
    public boolean containsHeader(String name) {
        return getHeaderNames().contains(name);
    }
}
