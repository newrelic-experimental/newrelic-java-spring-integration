package org.springframework.integration.transaction;

import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.weaver.NewField;
import com.newrelic.api.agent.weaver.Weave;
import org.springframework.lang.Nullable;

@Weave(originalName = "org.springframework.integration.transaction.IntegrationResourceHolder")
public class IntegrationResourceHolder_Instrumentation {

    @NewField
    @Nullable
    public Token token = null;


}
