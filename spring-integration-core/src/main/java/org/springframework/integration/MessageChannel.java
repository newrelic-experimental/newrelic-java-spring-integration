package org.springframework.integration;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.Interface)
public abstract class MessageChannel {

	@Trace
	public boolean send(Message<?> message) {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessageChannel",getClass().getSimpleName(),"send"});
		return Weaver.callOriginal();
	}
	
	@Trace
	public boolean send(Message<?> message, long timeout) {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessageChannel",getClass().getSimpleName(),"send"});
		boolean b = Weaver.callOriginal();
		return b;
	}
}
