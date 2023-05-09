package org.springframework.integration.gateway;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave
public abstract class GatewayProxyFactoryBean {

	public Object invoke(final MethodInvocation invocation) {
		Method method = invocation.getMethod();
		String classname = method.getDeclaringClass().getSimpleName();
		String methodName = method.getName();
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","GatewayProxyFactoryBean","invoke",classname,methodName);
		return Weaver.callOriginal();
	}
}
