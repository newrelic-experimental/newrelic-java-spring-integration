package org.springframework.messaging.core;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import org.springframework.messaging.Message;

@Weave(type = MatchType.Interface, originalName = "org.springframework.messaging.core.MessageReceivingOperations")
public class MessageReceivingOperations_Instrumentation {

    @Trace(dispatcher = true)
    public Message<?> receive() {
        Message<?> result = Weaver.callOriginal();
        if(result == null) {
            NewRelic.getAgent().getTransaction().ignore();
        }
        return result;
    }
}
