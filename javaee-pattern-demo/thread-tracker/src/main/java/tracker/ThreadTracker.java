package tracker;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class ThreadTracker {
	@AroundInvoke
	public Object annotateThread(InvocationContext invCtx) throws Exception {
		String originName = Thread.currentThread().getName();
		String beanName = invCtx.getTarget().getClass().getName();
		String tracingName = beanName + "#" + invCtx.getMethod().getName()
				+ " " + originName;
		try {
			Thread.currentThread().setName(tracingName);
			return invCtx.proceed();
		} finally {
			Thread.currentThread().setName(originName);
		}
	}

}
