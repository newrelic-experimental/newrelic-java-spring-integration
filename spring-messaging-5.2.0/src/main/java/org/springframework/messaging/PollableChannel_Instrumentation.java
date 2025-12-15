package org.springframework.messaging;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TransportType;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.spring.messaging.SpringMessageHeaders;

@Weave(type=MatchType.Interface, originalName = "org.springframework.messaging.PollableChannel")
public abstract class PollableChannel_Instrumentation {

    @Trace(dispatcher=true)
    public Message<?> receive() {
        NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","PollableChannel",getClass().getSimpleName(),"receive"});
        Message<?> msg = Weaver.callOriginal();
        if(msg == null) {
            NewRelic.getAgent().getTransaction().ignore();
        } else {
            SpringMessageHeaders<?> headers = new SpringMessageHeaders<>(msg);
            NewRelic.getAgent().getTransaction().acceptDistributedTraceHeaders(TransportType.Other, headers);
        }
        return msg;
    }

    @Trace(dispatcher=true)
    public Message<?> receive(long timeout) {
        NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","PollableChannel",getClass().getSimpleName(),"receive"});
        Message<?> msg = Weaver.callOriginal();
        if(msg == null) {
            NewRelic.getAgent().getTransaction().ignore();
        } else {
            SpringMessageHeaders<?> headers = new SpringMessageHeaders<>(msg);
            NewRelic.getAgent().getTransaction().acceptDistributedTraceHeaders(TransportType.Other, headers);
        }
        return msg;
    }
}
