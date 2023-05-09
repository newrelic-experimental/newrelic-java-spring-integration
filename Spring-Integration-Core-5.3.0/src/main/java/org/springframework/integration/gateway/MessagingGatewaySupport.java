package org.springframework.integration.gateway;

import org.springframework.messaging.Message;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.BaseClass)
public abstract class MessagingGatewaySupport {

	@Trace(dispatcher=true)
	protected Object receive() {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessagingGatewaySupport",getClass().getSimpleName(),"receive"});
		return Weaver.callOriginal();
	}
	
	@Trace
	protected void send(Object object) {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessagingGatewaySupport",getClass().getSimpleName(),"send"});
		Weaver.callOriginal();
	}
	
	@Trace
	protected Object sendAndReceive(Object object) {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessagingGatewaySupport",getClass().getSimpleName(),"sendAndReceive"});
		return Weaver.callOriginal();
	}
	
	@Trace
	protected Message<?> sendAndReceiveMessage(Object object) {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessagingGatewaySupport",getClass().getSimpleName(),"sendAndReceiveMessage"});
		return Weaver.callOriginal();
	}
}
