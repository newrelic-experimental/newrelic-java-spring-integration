package com.newrelic.instrumentation.labs.spring.messaging;

public class NRCancelRunnable implements Runnable {

    private NRHolder nrHolder;
    public NRCancelRunnable(NRHolder nrHolder) {
        this.nrHolder = nrHolder;
    }

    @Override
    public void run() {
        if(nrHolder != null) {
            nrHolder.endSegment();
        }
    }
}
