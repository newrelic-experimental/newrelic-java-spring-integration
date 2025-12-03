package com.newrelic.instrumentation.labs.spring.messaging;

import com.newrelic.api.agent.NewRelic;

import java.util.function.Consumer;

public class NRErrorConsumer implements Consumer<Throwable> {

    private final NRHolder nrHolder;

    public NRErrorConsumer(NRHolder nrHolder) {
        this.nrHolder = nrHolder;
    }

    @Override
    public void accept(Throwable throwable) {
        NewRelic.noticeError(throwable);
        if(nrHolder != null) {
            nrHolder.endSegment();
        }
    }
}
