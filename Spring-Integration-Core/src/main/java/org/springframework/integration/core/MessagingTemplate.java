package org.springframework.integration.core;

import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.message.ErrorMessage;
import org.springframework.ws.soap.SoapFault;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.BaseClass)
public abstract class MessagingTemplate {

	@Trace
	private void doSend(MessageChannel channel, Message<?> message) {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessagingTemplate",getClass().getSimpleName(),"send"});
		Weaver.callOriginal();
	}
	
	@Trace
	private <S, R> Message<R> doSendAndReceive(MessageChannel channel, Message<S> requestMessage) {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessagingTemplate",getClass().getSimpleName(),"sendAndReceive"});
		Message<R> msg = Weaver.callOriginal();
		if(msg instanceof ErrorMessage) {
			Throwable t = ((ErrorMessage)msg).getPayload();
			if(t instanceof SoapFault) {
				NewRelic.noticeError(t);
			}
		}
		return msg;
	}

	@Trace
	private <P> Message<P> doReceive(PollableChannel channel) {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessagingTemplate",getClass().getSimpleName(),"receive"});
		return Weaver.callOriginal();
	}
}
