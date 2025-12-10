package org.springframework.messaging;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.TransportType;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.spring.messaging.SpringMessageHeaders;

@Weave(type = MatchType.Interface, originalName = "org.springframework.messaging.MessageHandler")
public class MessageHandler_Instrumentation {

    public void handleMessage(Message<?> message) {
        SpringMessageHeaders<?> headers = new SpringMessageHeaders<>(message);
        NewRelic.getAgent().getTransaction().acceptDistributedTraceHeaders(TransportType.Other, headers);

        Weaver.callOriginal();
    }
}
