package org.springframework.integration.endpoint;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import org.springframework.messaging.Message;

@Weave(originalName = "org.springframework.integration.endpoint.SourcePollingChannelAdapter")
public class SourcePollingChannelAdapter_Instrumentation {

    @Trace(dispatcher=true)
    protected void handleMessage(Message<?> message) {
        NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","SourcePollingChannelAdapter","handleMessage"});
        Weaver.callOriginal();
    }

    @Trace(dispatcher=true)
    protected Message<?> receiveMessage(){
        NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","SourcePollingChannelAdapter","receiveMessage"});
        return Weaver.callOriginal();
    }


}
