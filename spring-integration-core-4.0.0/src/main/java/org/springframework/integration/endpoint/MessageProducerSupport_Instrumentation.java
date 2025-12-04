package org.springframework.integration.endpoint;

import org.springframework.messaging.Message;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;

@Weave(type=MatchType.BaseClass, originalName = "org.springframework.integration.endpoint.MessageProducerSupport")
public abstract class MessageProducerSupport_Instrumentation {

	@Trace
	protected abstract void sendMessage(Message<?> message);
}
