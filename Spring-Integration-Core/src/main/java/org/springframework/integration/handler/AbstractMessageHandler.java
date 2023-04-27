package org.springframework.integration.handler;

import org.springframework.integration.Message;
import org.springframework.integration.context.IntegrationObjectSupport;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TransactionNamePriority;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.Interface)
public abstract class AbstractMessageHandler extends IntegrationObjectSupport  {

	@Trace(dispatcher=true)
	public void handleMessage(Message<?> message) {
		NewRelic.getAgent().getTransaction().setTransactionName(TransactionNamePriority.FRAMEWORK_HIGH, true, "MessageHandler", new String[] {"MessageHandler",getComponentName()});
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessageHandler",getClass().getSimpleName(),"handleMessage"});
		Weaver.callOriginal();
	}
}
