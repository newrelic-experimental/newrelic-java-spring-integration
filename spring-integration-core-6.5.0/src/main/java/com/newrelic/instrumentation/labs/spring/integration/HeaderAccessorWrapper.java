package com.newrelic.instrumentation.labs.spring.integration;

import com.newrelic.api.agent.HeaderType;
import com.newrelic.api.agent.Headers;
import org.springframework.integration.IntegrationMessageHeaderAccessor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HeaderAccessorWrapper  implements Headers {

    private final IntegrationMessageHeaderAccessor headerAccessor;

    public HeaderAccessorWrapper(IntegrationMessageHeaderAccessor headerAccessor) {
        this.headerAccessor = headerAccessor;
    }

    @Override
    public HeaderType getHeaderType() {
        return HeaderType.MESSAGE;
    }

    @Override
    public String getHeader(String name) {
        Object value = headerAccessor.getHeader(name);
        if (value != null) {
            if(value instanceof String) {
                return (String) value;
            }
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
        headerAccessor.setHeader(name, value);
    }

    @Override
    public void addHeader(String name, String value) {
        headerAccessor.setHeader(name, value);
    }

    @Override
    public Collection<String> getHeaderNames() {
        return headerAccessor.getMessageHeaders().keySet();
    }

    @Override
    public boolean containsHeader(String name) {
        return getHeaderNames().contains(name);
    }
}
