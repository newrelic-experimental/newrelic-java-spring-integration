package org.springframework.integration.endpoint;

import org.springframework.integration.Message;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.BaseClass)
public abstract class AbstractPollingEndpoint {

	@Trace(dispatcher=true)
	protected void handleMessage(Message<?> message) {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","AbstractPollingEndpoint",getClass().getSimpleName(),"handleMessage"});
		Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	protected Message<?> receiveMessage(){
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","AbstractPollingEndpoint",getClass().getSimpleName(),"receiveMessage"});
		return Weaver.callOriginal();
	}
}
