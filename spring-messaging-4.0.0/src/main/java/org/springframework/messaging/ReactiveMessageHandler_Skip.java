package org.springframework.messaging;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.SkipIfPresent;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.spring.messaging.NRCancelRunnable;
import com.newrelic.instrumentation.labs.spring.messaging.NRErrorConsumer;
import com.newrelic.instrumentation.labs.spring.messaging.NRHolder;
import com.newrelic.instrumentation.labs.spring.messaging.NRResultConsumer;
import reactor.core.publisher.Mono;

@SkipIfPresent( originalName = "org.springframework.messaging.ReactiveMessageHandler")
public class ReactiveMessageHandler_Skip {

    @Trace
    public Mono<Void> handleMessage(Message<?> var1) {
        NRHolder nrHolder = new NRHolder(NewRelic.getAgent().getTransaction().startSegment("Custom/ReactiveMessageHandler/handleMessage"));
        Mono<Void>  result = Weaver.callOriginal();
        return result.doOnCancel(new NRCancelRunnable(nrHolder)).doOnError(new NRErrorConsumer(nrHolder)).doOnSuccess(new NRResultConsumer<>(nrHolder));
    }
}
