package org.springframework.messaging.core;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel_Instrumentation;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.BaseClass)
public abstract class GenericMessagingTemplate {

    @Trace
    protected final void doSend(MessageChannel_Instrumentation channel, Message<?> message) {
        NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","GenericMessagingTemplate",getClass().getSimpleName(),"send"});
        Weaver.callOriginal();
    }

    @Trace
    protected final Message<?> doSendAndReceive(MessageChannel_Instrumentation channel, Message<?> requestMessage) {
        NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","GenericMessagingTemplate",getClass().getSimpleName(),"sendAndReceive"});
        return Weaver.callOriginal();
    }

    @Trace
    protected final Message<?> doReceive(MessageChannel_Instrumentation channel) {
        NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","GenericMessagingTemplate",getClass().getSimpleName(),"receive"});
        return Weaver.callOriginal();
    }
}
