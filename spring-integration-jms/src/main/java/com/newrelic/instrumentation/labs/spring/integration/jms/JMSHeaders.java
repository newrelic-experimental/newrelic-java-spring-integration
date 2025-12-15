package com.newrelic.instrumentation.labs.spring.integration.jms;

import com.newrelic.api.agent.HeaderType;
import com.newrelic.api.agent.Headers;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

import java.util.*;

public class JMSHeaders implements Headers {

    private Message message;

    public JMSHeaders(Message message) {
        this.message = message;
    }

    @Override
    public HeaderType getHeaderType() {
        return HeaderType.MESSAGE;
    }

    @Override
    public String getHeader(String name) {
        try {
            Object value = message.getObjectProperty(name);
            if (value != null) {
                return value.toString();
            }
        } catch (JMSException ignored) {
        }
        return null;
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
        try {
            message.setStringProperty(name,value);
        } catch (JMSException ignored) {
        }
    }

    @Override
    public void addHeader(String name, String value) {
        try {
            message.setStringProperty(name,value);
        } catch (JMSException ignored) {
        }
    }

    @Override
    public Collection<String> getHeaderNames() {
        List<String> headerNames = new ArrayList<>();
        try {
            Enumeration names = message.getPropertyNames();
            while (names.hasMoreElements()) {
                String name = (String) names.nextElement();
                headerNames.add(name);
            }
        } catch (JMSException ignored) {
        }
        return headerNames;
    }

    @Override
    public boolean containsHeader(String name) {
        return getHeaderNames().contains(name);
    }
}
