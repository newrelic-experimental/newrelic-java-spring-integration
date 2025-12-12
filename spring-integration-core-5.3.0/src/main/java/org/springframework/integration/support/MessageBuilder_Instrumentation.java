package org.springframework.integration.support;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.spring.integration.HeaderAccessorWrapper;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.messaging.Message;

import java.util.logging.Level;

@Weave(originalName = "org.springframework.integration.support.MessageBuilder")
public class MessageBuilder_Instrumentation<T> {

    private final IntegrationMessageHeaderAccessor headerAccessor = Weaver.callOriginal();

    public Message<T> build() {
        HeaderAccessorWrapper wrapper = new HeaderAccessorWrapper(headerAccessor);
        NewRelic.getAgent().getTransaction().insertDistributedTraceHeaders(wrapper);
        return Weaver.callOriginal();
    }
}
