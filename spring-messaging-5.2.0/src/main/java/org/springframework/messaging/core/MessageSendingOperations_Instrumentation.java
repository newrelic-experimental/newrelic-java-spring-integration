package org.springframework.messaging.core;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.spring.messaging.SpringMessageHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;

import java.util.Map;

@Weave(type = MatchType.Interface, originalName = "org.springframework.messaging.core.MessageSendingOperations")
public class MessageSendingOperations_Instrumentation<D> {

    @Trace
    public void send(Message<?> message) {
        Weaver.callOriginal();
    }

    @Trace
    public void send(D var1, Message<?> message) {
        Weaver.callOriginal();
    }

    @Trace
    public void convertAndSend(Object var1) {
        Weaver.callOriginal();
    }

    @Trace
    public void convertAndSend(D var1, Object var2) {
        Weaver.callOriginal();
    }

    @Trace
    public void convertAndSend(D var1, Object var2, Map<String, Object> var3) {
        Weaver.callOriginal();
    }

    @Trace
    public void convertAndSend(Object var1, MessagePostProcessor var2) {
        Weaver.callOriginal();
    }

    @Trace
    public void convertAndSend(D var1, Object var2, MessagePostProcessor var3) {
        Weaver.callOriginal();
    }

    @Trace
    public void convertAndSend(D var1, Object var2, Map<String, Object> var3, MessagePostProcessor var4) {
        Weaver.callOriginal();
    }

}
