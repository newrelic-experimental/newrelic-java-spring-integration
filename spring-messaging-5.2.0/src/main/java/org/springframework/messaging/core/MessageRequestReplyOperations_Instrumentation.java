package org.springframework.messaging.core;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.spring.messaging.SpringMessageHeaders;
import org.springframework.messaging.Message;

import java.util.Map;

@Weave(type = MatchType.Interface, originalName = "org.springframework.messaging.core.MessageRequestReplyOperations")
public class MessageRequestReplyOperations_Instrumentation<D> {

    @Trace
    public Message<?> sendAndReceive(Message<?> var1) {
        return Weaver.callOriginal();
    }

    public Message<?> sendAndReceive(D var1, Message<?> var2) {
        return Weaver.callOriginal();
    }

    public <T> T convertSendAndReceive(Object var1, Class<T> var2) {
        return Weaver.callOriginal();
    }

    public <T> T convertSendAndReceive(D var1, Object var2, Class<T> var3) {
        return Weaver.callOriginal();
    }

    public <T> T convertSendAndReceive(D var1, Object var2, Map<String, Object> var3, Class<T> var4) {
        return Weaver.callOriginal();
    }

    public <T> T convertSendAndReceive(Object var1, Class<T> var2, MessagePostProcessor var3) {
        return Weaver.callOriginal();
    }

    public <T> T convertSendAndReceive(D var1, Object var2, Class<T> var3, MessagePostProcessor var4) {
        return Weaver.callOriginal();
    }

    public <T> T convertSendAndReceive(D var1, Object var2, Map<String, Object> var3, Class<T> var4, MessagePostProcessor var5) {
        return Weaver.callOriginal();
    }
}
