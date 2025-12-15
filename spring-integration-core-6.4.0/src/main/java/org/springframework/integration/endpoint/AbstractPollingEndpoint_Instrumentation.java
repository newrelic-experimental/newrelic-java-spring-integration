package org.springframework.integration.endpoint;

import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.TransportType;
import com.newrelic.instrumentation.labs.spring.integration.SpringMessageHeaders;
import org.springframework.integration.transaction.IntegrationResourceHolder_Instrumentation;
import org.springframework.messaging.Message;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.BaseClass, originalName = "org.springframework.integration.endpoint.AbstractPollingEndpoint")
public abstract class AbstractPollingEndpoint_Instrumentation {

    @Trace(dispatcher=true)
	private Message<?> doPoll() {

        Message<?> message = Weaver.callOriginal();
        if(message != null) {
            SpringMessageHeaders headers = new SpringMessageHeaders(message);
            NewRelic.getAgent().getTransaction().acceptDistributedTraceHeaders(TransportType.Other, headers);
        } else {
            NewRelic.getAgent().getTransaction().ignore();
        }
        return message;
    }

    private IntegrationResourceHolder_Instrumentation bindResourceHolderIfNecessary(String key, Object resource) {
        IntegrationResourceHolder_Instrumentation holder = (IntegrationResourceHolder_Instrumentation) Weaver.callOriginal();
        if (holder != null) {
            Token token = NewRelic.getAgent().getTransaction().getToken();
            if (token != null) {
                if(token.isActive()) {
                    holder.token = token;
                }  else {
                    token.expire();
                    token = null;
                }
            }
        }
        return holder;
    }

    @Trace(async=true)
    private void messageReceived(IntegrationResourceHolder_Instrumentation holder, Message<?> message) {
        if (holder != null) {
            if (holder.token != null) {
                holder.token.linkAndExpire();
                holder.token = null;
            }
        }
        Weaver.callOriginal();
    }
 }
