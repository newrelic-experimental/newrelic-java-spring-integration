package org.springframework.integration.handler;

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
		NewRelic.getAgent().getTransaction().setTransactionName(TransactionNamePriority.FRAMEWORK_HIGH, true, "MessageHandler", new String[] {"MessageHandler",getComponentName()});
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessageHandler",getClass().getSimpleName(),"handleMessage"});
		Weaver.callOriginal();
	}
}
