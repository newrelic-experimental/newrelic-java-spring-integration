package org.springframework.integration.handler;

import org.springframework.messaging.Message;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

import java.util.logging.Level;

@Weave(type=MatchType.Interface)
public abstract class MessageProcessor<T> {

	@Trace
	public T processMessage(Message<?> message)  {
		NewRelic.getAgent().getLogger().log(Level.FINE,new Exception("Call to processMessage"),"Call to processMessage in class {0}", this.getClass().getName());
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessageProcessor",getClass().getSimpleName(),"processMessage"});
		return Weaver.callOriginal();
	}
}
