package tracker;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.Map;

import javax.interceptor.InvocationContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ThreadTrackerTest {
	private ThreadTracker threadTracker;

	private String threadName;

	@Before
	public void setUp() throws Exception {
		this.threadTracker = new ThreadTracker();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAnnotateThread() throws Exception {

		InvocationContext ic = new InvocationContext() {

			@Override
			public Map<String, Object> getContextData() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Method getMethod() {
				try {
					return ThreadTrackerTest.class.getMethod(
							"testAnnotateThread", (Class[]) null);
				} catch (NoSuchMethodException ex) {
					throw new IllegalStateException("Cannot find method " + ex,
							ex);
				}
			}

			@Override
			public Object[] getParameters() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object getTarget() {
				return ThreadTrackerTest.this;
			}

			@Override
			public Object getTimer() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object proceed() throws Exception {
				ThreadTrackerTest.this.setThreadName(Thread.currentThread()
						.getName());
				return null;
			}

			@Override
			public void setParameters(Object[] arg0) {
				// TODO Auto-generated method stub

			}
		};

		this.threadTracker.annotateThread(ic);
		assertNotNull(this.threadName);
		assertTrue(this.threadName.startsWith(this.getClass().getName()));
		System.out.println("Thread Name: " + this.threadName);

	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

}
