package com.newrelic.instrumentation.labs.spring.messaging;

import com.newrelic.api.agent.Segment;

public class NRHolder {

    private Segment segment;

    public NRHolder(Segment segment) {
        this.segment = segment;
    }

    public void endSegment() {
        if(segment != null) {
            segment.end();
            segment = null;
        }
    }

    public void ignoreSegment() {
        if(segment != null) {
            segment.ignore();
            segment = null;
        }
    }
}
