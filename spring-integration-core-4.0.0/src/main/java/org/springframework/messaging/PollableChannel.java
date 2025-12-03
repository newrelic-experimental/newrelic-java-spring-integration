package org.springframework.messaging;

import org.springframework.messaging.Message;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.Interface)
public abstract class PollableChannel {

	@Trace(dispatcher=true)
	public Message<?> receive() {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","PollableChannel",getClass().getSimpleName(),"receive"});
		Message<?> msg = Weaver.callOriginal();
		if(msg == null) {
			NewRelic.getAgent().getTransaction().ignore();
		}
		return msg;
	}
	
	@Trace(dispatcher=true)
	public Message<?> receive(long timeout) {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","PollableChannel",getClass().getSimpleName(),"receive"});
		Message<?> msg = Weaver.callOriginal();
		if(msg == null) {
			NewRelic.getAgent().getTransaction().ignore();
		}
		return msg;
	}
}
