package thread;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable arg0, ThreadPoolExecutor arg1) {
		System.out.println(arg0.toString() + " is rejected");
	}

}
