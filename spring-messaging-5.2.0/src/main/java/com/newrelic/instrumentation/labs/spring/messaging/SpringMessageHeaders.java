package com.newrelic.instrumentation.labs.spring.messaging;

import com.newrelic.api.agent.HeaderType;
import com.newrelic.api.agent.Headers;
import org.springframework.messaging.Message;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SpringMessageHeaders<T> implements Headers {

    private final Message<T> message;

    public SpringMessageHeaders(Message<T> message) {
        this.message = message;
    }

    @Override
    public HeaderType getHeaderType() {
        return HeaderType.MESSAGE;
    }

    @Override
    public String getHeader(String name) {
        return message.getHeaders().get(name, String.class);
    }

    @Override
    public Collection<String> getHeaders(String name) {
        List<String> headers = new ArrayList<>();
        String header = getHeader(name);
        if (header != null) {
            headers.add(header);
        }
        return headers;
    }

    @Override
    public void setHeader(String name, String value) {
        message.getHeaders().put(name, value);
    }

    @Override
    public void addHeader(String name, String value) {
        message.getHeaders().put(name, value);
    }

    @Override
    public Collection<String> getHeaderNames() {
        return message.getHeaders().keySet();
    }

    @Override
    public boolean containsHeader(String name) {
        return getHeaderNames().contains(name);
    }
}
