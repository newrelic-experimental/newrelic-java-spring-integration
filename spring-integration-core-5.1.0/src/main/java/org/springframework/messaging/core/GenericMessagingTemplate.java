package org.springframework.messaging.core;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.ws.soap.SoapFault;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.BaseClass)
public abstract class GenericMessagingTemplate {

	@Trace
	protected final void doSend(MessageChannel channel, Message<?> message) {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","GenericMessagingTemplate",getClass().getSimpleName(),"send"});
		Weaver.callOriginal();
	}
	
	@Trace
	protected final Message<?> doSendAndReceive(MessageChannel channel, Message<?> requestMessage) {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","GenericMessagingTemplate",getClass().getSimpleName(),"sendAndReceive"});
		Message<?> msg = Weaver.callOriginal();
		if(msg instanceof ErrorMessage) {
			Throwable t = ((ErrorMessage)msg).getPayload();
			if(t instanceof SoapFault) {
				NewRelic.noticeError(t);
			}
		}
		return msg;
	}

	@Trace
	protected final Message<?> doReceive(MessageChannel channel) {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","GenericMessagingTemplate",getClass().getSimpleName(),"receive"});
		return Weaver.callOriginal();
	}
}
