package com.newrelic.instrumentation.labs.spring.integration;

import com.newrelic.agent.bridge.AgentBridge;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class SpringIntegrationUtils {

    private static final Set<Method> instrumentedMethods = new HashSet<>();

    public static void checkWhetherToInstrument(Method method) {
        if(!instrumentedMethods.contains(method)) {
            AgentBridge.instrumentation.instrument(method, "Custom/MethodInvoker/");
            instrumentedMethods.add(method);
        }
    }
}
