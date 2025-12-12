package org.springframework.integration.jms;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TransportType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.spring.integration.jms.JMSHeaders;
import jakarta.jms.Destination;
import jakarta.jms.Session;

@Weave(originalName = "org.springframework.integration.jms.ChannelPublishingJmsMessageListener")
public class ChannelPublishingJmsMessageListener_Instrumentation {


    public void onMessage(jakarta.jms.Message jmsMessage, Session session) {
        NewRelic.getAgent().getTransaction().acceptDistributedTraceHeaders(TransportType.JMS,new JMSHeaders(jmsMessage));
        Weaver.callOriginal();
    }

    @Trace
    private void sendReply(jakarta.jms.Message replyMessage, Destination destination, Session session) {
        Weaver.callOriginal();
    }
}
