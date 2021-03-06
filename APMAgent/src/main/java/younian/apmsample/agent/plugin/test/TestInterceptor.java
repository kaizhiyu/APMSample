package younian.apmsample.agent.plugin.test;

import younian.apmsample.agent.context.ContextManager;
import younian.apmsample.agent.intercept.ClassInstanceMethodInterceptor;

import java.lang.reflect.Method;

public class TestInterceptor extends ClassInstanceMethodInterceptor {
    protected void before(Method method, Object[] allArguments){
        ContextManager.createSpan("Test" ,method.getName());
    }

    @Override
    protected Object after(Object result, Object[] allArguments) {
        ContextManager.stopSpan();
        return result;
    }
}
