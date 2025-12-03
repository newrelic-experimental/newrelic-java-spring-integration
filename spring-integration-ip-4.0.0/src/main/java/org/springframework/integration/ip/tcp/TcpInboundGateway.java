package org.springframework.integration.ip.tcp;

import org.springframework.messaging.Message;
import org.springframework.integration.gateway.MessagingGatewaySupport;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TransactionNamePriority;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave
public abstract class TcpInboundGateway extends MessagingGatewaySupport {

	@Trace(dispatcher=true)
	public boolean onMessage(Message<?> message) {
		NewRelic.getAgent().getTransaction().setTransactionName(TransactionNamePriority.FRAMEWORK_HIGH, true, "TcpInboundGateway", new String[] {"TcpInboundGateway",getComponentName()});
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","TcpInboundGateway",getComponentName(),"onMessage"});
		return Weaver.callOriginal();
	}
}
