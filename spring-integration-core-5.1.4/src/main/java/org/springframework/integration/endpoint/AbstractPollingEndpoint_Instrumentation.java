package org.springframework.integration.endpoint;

import com.newrelic.api.agent.TransportType;
import com.newrelic.instrumentation.labs.spring.integration.SpringMessageHeaders;
import org.springframework.messaging.Message;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.BaseClass, originalName = "org.springframework.integration.endpoint.AbstractPollingEndpoint")
public abstract class AbstractPollingEndpoint_Instrumentation {

	@Trace(dispatcher=true)
	private Message<?> doPoll() {

		Message<?> message = Weaver.callOriginal();
		if(message != null) {
			SpringMessageHeaders headers = new SpringMessageHeaders(message);
			NewRelic.getAgent().getTransaction().acceptDistributedTraceHeaders(TransportType.Other, headers);
		} else {
			NewRelic.getAgent().getTransaction().ignore();
		}
		return message;
	}

}
