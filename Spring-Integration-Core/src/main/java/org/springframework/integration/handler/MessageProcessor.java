package org.springframework.integration.handler;

import org.springframework.integration.Message;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.Interface)
public abstract class MessageProcessor<T> {

	@Trace
	public T processMessage(Message<?> message)  {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessageProcessor",getClass().getSimpleName(),"processMessage"});
		return Weaver.callOriginal();
	}
}
