package com.newrelic.instrumentation.labs.spring.messaging;

import java.util.function.Consumer;

public class NRResultConsumer<T> implements Consumer<T> {

    private final NRHolder nrHolder;

    public NRResultConsumer(NRHolder nrHolder) {
        this.nrHolder = nrHolder;
    }

    @Override
    public void accept(T t) {
        if(nrHolder != null) {
            nrHolder.endSegment();
        }
    }
}
