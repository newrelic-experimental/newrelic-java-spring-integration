package org.springframework.messaging;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.Interface, originalName = "org.springframework.messaging.MessageChannel")
public abstract class MessageChannel_Instrumentation {

    @Trace
    public boolean send(Message<?> message) {
        NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessageChannel",getClass().getSimpleName(),"send"});
        return Weaver.callOriginal();
    }

    @Trace
    public boolean send(Message<?> message, long timeout) {
        NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessageChannel",getClass().getSimpleName(),"send"});
        return Weaver.callOriginal();
    }
}
