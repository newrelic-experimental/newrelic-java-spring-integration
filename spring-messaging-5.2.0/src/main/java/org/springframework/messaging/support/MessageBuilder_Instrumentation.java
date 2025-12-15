package org.springframework.messaging.support;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.spring.messaging.SpringHeaderAccessorWrapper;
import org.springframework.messaging.Message;

import java.util.logging.Level;

@Weave(originalName = "org.springframework.messaging.support.MessageBuilder")
public class MessageBuilder_Instrumentation<T> {

    private MessageHeaderAccessor headerAccessor = Weaver.callOriginal();

    public Message<T> build() {
        SpringHeaderAccessorWrapper springHeaderAccessorWrapper = new SpringHeaderAccessorWrapper(headerAccessor);
        NewRelic.getAgent().getTransaction().insertDistributedTraceHeaders(springHeaderAccessorWrapper);
        return Weaver.callOriginal();
    }
}
