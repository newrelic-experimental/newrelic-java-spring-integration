package org.springframework.integration.endpoint;

import org.springframework.integration.Message;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;

@Weave(type=MatchType.BaseClass)
public abstract class MessageProducerSupport {

	@Trace
	protected abstract void sendMessage(Message<?> message);
}
