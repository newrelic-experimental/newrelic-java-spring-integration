package org.springframework.integration.core;

import org.springframework.messaging.Message;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.Interface, originalName = "org.springframework.integration.core.MessageSelector")
public abstract class MessageSelector_Instrumentation {

	@Trace(dispatcher=true)
	public boolean accept(Message<?> message) {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessageSelector",getClass().getSimpleName(),"accept"});
		return Weaver.callOriginal();
	}
}
