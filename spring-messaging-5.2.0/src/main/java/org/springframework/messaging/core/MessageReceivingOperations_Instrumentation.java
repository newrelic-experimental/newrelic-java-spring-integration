package org.springframework.messaging.core;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TransportType;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.spring.messaging.SpringMessageHeaders;
import org.springframework.messaging.Message;

@Weave(type = MatchType.Interface, originalName = "org.springframework.messaging.core.MessageReceivingOperations")
public class MessageReceivingOperations_Instrumentation {

    @Trace(dispatcher = true)
    public Message<?> receive() {
        Message<?> result = Weaver.callOriginal();
        if(result == null) {
            NewRelic.getAgent().getTransaction().ignore();
        } else {
            SpringMessageHeaders<?> headers = new SpringMessageHeaders<>(result);
            NewRelic.getAgent().getTransaction().acceptDistributedTraceHeaders(TransportType.Other, headers);
        }
        return result;
    }
}
