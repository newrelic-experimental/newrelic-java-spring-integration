package org.springframework.messaging;

import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type = MatchType.Interface, originalName = "org.springframework.messaging.MessageHandler")
public class MessageHandler_Instrumentation {

    public void handleMessage(Message<?> message) {
        Weaver.callOriginal();
    }
}
