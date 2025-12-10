package org.springframework.integration.handler.support;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

import com.newrelic.api.agent.Trace;
import com.newrelic.instrumentation.labs.spring.integration.SpringIntegrationUtils;
import org.springframework.integration.util.AbstractExpressionEvaluator;
import org.springframework.messaging.Message;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(originalName = "org.springframework.integration.handler.support.MessagingMethodInvokerHelper")
public abstract class MessagingMethodInvokerHelper_Instrumentation<T> extends AbstractExpressionEvaluator {

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
	private Object invokeHandlerMethod(HandlerMethod_Instrumentation handlerMethod, ParametersWrapper_Instrumentation parameters) {
		return Weaver.callOriginal();
	}

	@Trace
	public T process(Message<?> message) {

		return Weaver.callOriginal();
	}

	@Trace
	private Object processInternal(ParametersWrapper_Instrumentation parameters) {
		return Weaver.callOriginal();
	}

	@Weave(originalName = "org.springframework.integration.handler.support.MessagingMethodInvokerHelper$ParametersWrapper")
	public static class ParametersWrapper_Instrumentation {

	}

	@Weave(originalName = "org.springframework.integration.handler.support.MessagingMethodInvokerHelper$HandlerMethod")
	private static class HandlerMethod_Instrumentation {

		private final Method method = Weaver.callOriginal();

		@Trace
		public Object invoke(ParametersWrapper_Instrumentation parameters) {
			SpringIntegrationUtils.checkWhetherToInstrument(method);
			return Weaver.callOriginal();
		}

	}
}
