package org.springframework.integration.core;

import org.springframework.messaging.Message;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.Interface)
public abstract class MessageSource<T> {

	@Trace(dispatcher=true)
	public Message<T> receive() {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessageSource",getClass().getSimpleName(),"receive"});
		return Weaver.callOriginal();
	}
}
