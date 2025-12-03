package org.springframework.integration.dispatcher;

import org.springframework.messaging.Message;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.Interface, originalName = "org.springframework.integration.dispatcher.MessageDispatcher")
public abstract class MessageDispatcher_Instrumentation {

	@Trace
	public boolean dispatch(Message<?> message) {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessageDispatcher",getClass().getSimpleName(),"dispatch"});
		return Weaver.callOriginal();
	}
}
