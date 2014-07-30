package thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestDateFormat {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {

		final DateFormatDemo t = new DateFormatDemo();

		Callable<Date> task = new Callable<Date>() {
			public Date call() throws Exception {
				// return t.convert("20100811");
				return t.safeConvert("20100811");
			}
		};

		ExecutorService exec = Executors.newFixedThreadPool(2);
		List<Future<Date>> results = new ArrayList<Future<Date>>();

		// 实现5次日期转换
		for (int i = 0; i < 5; i++) {
			results.add(exec.submit(task));
		}
		exec.shutdown();

		// 查看结果
		for (Future<Date> result : results) {
			System.out.println(result.get());
		}

	}

}
