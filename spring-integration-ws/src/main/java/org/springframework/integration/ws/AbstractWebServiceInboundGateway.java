package org.springframework.integration.ws;

import org.springframework.ws.context.MessageContext;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.BaseClass)
public abstract class AbstractWebServiceInboundGateway {

	@Trace(dispatcher=true)
	protected void doInvoke(MessageContext messageContext) {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","AbstractWebServiceInboundGateway",getClass().getSimpleName(),"doInvoke"});
		Weaver.callOriginal();
	}
}
