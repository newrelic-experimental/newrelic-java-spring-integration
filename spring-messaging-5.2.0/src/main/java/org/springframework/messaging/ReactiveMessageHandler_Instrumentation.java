package org.springframework.messaging;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TransportType;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.spring.messaging.NRCancelRunnable;
import com.newrelic.instrumentation.labs.spring.messaging.NRErrorConsumer;
import com.newrelic.instrumentation.labs.spring.messaging.NRHolder;
import com.newrelic.instrumentation.labs.spring.messaging.NRResultConsumer;
import com.newrelic.instrumentation.labs.spring.messaging.SpringMessageHeaders;
import reactor.core.publisher.Mono;

@Weave(type = MatchType.Interface, originalName = "org.springframework.messaging.ReactiveMessageHandler")
public class ReactiveMessageHandler_Instrumentation {

    @Trace
    public Mono<Void> handleMessage(Message<?> message) {
        SpringMessageHeaders<?> headers = new SpringMessageHeaders<>(message);
        NewRelic.getAgent().getTransaction().acceptDistributedTraceHeaders(TransportType.Other, headers);
        NRHolder nrHolder = new NRHolder(NewRelic.getAgent().getTransaction().startSegment("Custom/ReactiveMessageHandler/handleMessage"));
        Mono<Void>  result = Weaver.callOriginal();
        return result.doOnCancel(new NRCancelRunnable(nrHolder)).doOnError(new NRErrorConsumer(nrHolder)).doOnSuccess(new NRResultConsumer<>(nrHolder));
    }
}
