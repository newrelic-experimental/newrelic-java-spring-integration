package org.springframework.integration.ws;

import org.springframework.messaging.Message;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.BaseClass)
public abstract class AbstractWebServiceOutboundGateway {

	@Trace(dispatcher=true)
	public Object handleRequestMessage(Message<?> requestMessage) {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","AbstractWebServiceOutboundGateway",getClass().getSimpleName(),"handleRequestMessage"});
		return Weaver.callOriginal();
	}
}
