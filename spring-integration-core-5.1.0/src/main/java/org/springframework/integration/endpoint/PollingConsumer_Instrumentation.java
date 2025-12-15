package org.springframework.integration.endpoint;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import org.springframework.messaging.Message;

@Weave(originalName = "org.springframework.integration.endpoint.PollingConsumer")
public class PollingConsumer_Instrumentation {

    @Trace(dispatcher=true)
    protected void handleMessage(Message<?> message) {
        NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","PollingConsumer","handleMessage"});
        Weaver.callOriginal();
    }

    @Trace(dispatcher=true)
    protected Message<?> receiveMessage(){
        NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","PollingConsumer","receiveMessage"});
        return Weaver.callOriginal();
    }

}
