package org.springframework.integration.util;

import java.util.Collection;
import java.util.Map;

import org.springframework.messaging.Message;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave
public abstract class MessagingMethodInvokerHelper<T> extends AbstractExpressionEvaluator {

	public T process(Collection<Message<?>> messages, Map<String, ?> headers) {
		String displayStr = toString();
		if(displayStr != null && !displayStr.isEmpty()) {
			NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessagingMethodInvokerHelper","process",displayStr});
		} else {
			NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessagingMethodInvokerHelper","process","Unknown"});
		}
		return Weaver.callOriginal();
	}
	
	public T process(Message<?> message) {
		return Weaver.callOriginal();
	}
}
