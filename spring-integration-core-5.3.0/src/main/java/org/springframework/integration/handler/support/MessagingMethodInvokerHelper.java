package org.springframework.integration.handler.support;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Level;

import com.newrelic.api.agent.Trace;
import com.newrelic.instrumentation.labs.spring.integration.SpringIntegrationUtils;
import org.springframework.integration.util.AbstractExpressionEvaluator;
import org.springframework.messaging.Message;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import org.springframework.messaging.handler.invocation.InvocableHandlerMethod;

@Weave
public abstract class MessagingMethodInvokerHelper<T> extends AbstractExpressionEvaluator {

	@Trace
	public T process(Collection<Message<?>> messages, Map<String, ?> headers) {
		String displayStr = toString();
		if(displayStr != null && !displayStr.isEmpty()) {
			NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessagingMethodInvokerHelper","process",displayStr});
		} else {
			NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","MessagingMethodInvokerHelper","process","Unknown"});
		}
		return Weaver.callOriginal();
	}
	@Trace
	private Object invokeHandlerMethod(HandlerMethod handlerMethod, ParametersWrapper parameters) {
		return Weaver.callOriginal();
	}

	@Trace
	public T process(Message<?> message) {

		return Weaver.callOriginal();
	}

	@Trace
	private Object processInternal(ParametersWrapper parameters) {
		return Weaver.callOriginal();
	}

	@Weave
	public static class ParametersWrapper {

	}

	@Weave
	private static class HandlerMethod {

		private final Method method = Weaver.callOriginal();

		@Trace
		public Object invoke(ParametersWrapper parameters) {
			SpringIntegrationUtils.checkWhetherToInstrument(method);
			return Weaver.callOriginal();
		}

	}
}
