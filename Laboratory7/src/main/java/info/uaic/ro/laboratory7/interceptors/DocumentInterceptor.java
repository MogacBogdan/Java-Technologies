package info.uaic.ro.laboratory7.interceptors;

import info.uaic.ro.laboratory7.DocumentTracker;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class DocumentInterceptor {
    @Inject
    DocumentTracker documentTracker;

    @AroundInvoke
    private Object doLog(InvocationContext context) throws Exception {
        documentTracker.log(
                "Entering method : " + context.getMethod().getName() + "\n"
        );
        Object result = context.proceed();

        documentTracker.log(
                "Exit method : " + context.getMethod().getName() + "\n"
        );
        return result;
    }
}