package org.springframework.integration.jms;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TransportType;
import com.newrelic.api.agent.weaver.Weaver;
import com.newrelic.instrumentation.labs.spring.integration.jms.JMSHeaders;
import jakarta.jms.Message;

public class JmsDestinationPollingSource_Instrumentation {

    @Trace(dispatcher = true)
    protected Object doReceive() {

        return Weaver.callOriginal();
    }

    private Message doReceiveJmsMessage() {
        Message message = Weaver.callOriginal();
        if(message != null) {
            JMSHeaders headers = new JMSHeaders(message);
            NewRelic.getAgent().getTransaction().acceptDistributedTraceHeaders(TransportType.JMS, headers);
        } else {
            NewRelic.getAgent().getTransaction().ignore();
        }

        return message;
    }
}
