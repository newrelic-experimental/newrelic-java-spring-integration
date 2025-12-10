package org.springframework.integration.handler;

import com.newrelic.api.agent.TransportType;
import com.newrelic.instrumentation.labs.spring.integration.SpringMessageHeaders;
import org.springframework.messaging.Message;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TransactionNamePriority;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.BaseClass, originalName = "org.springframework.integration.handler.AbstractMessageHandler")
public abstract class AbstractMessageHandler_Instrumentation extends MessageHandlerSupport  {

	@Trace(dispatcher=true)
	public void handleMessage(Message<?> message) {
		SpringMessageHeaders headers = new SpringMessageHeaders(message);
		NewRelic.getAgent().getTransaction().acceptDistributedTraceHeaders(TransportType.Other, headers);
		NewRelic.getAgent().getTransaction().setTransactionName(TransactionNamePriority.FRAMEWORK_HIGH, true, "MessageHandler", new String[] {"MessageHandler",getComponentName()});
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessageHandler",getClass().getSimpleName(),"handleMessage"});
		Weaver.callOriginal();
	}
}
