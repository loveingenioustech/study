package strategy;

public class LogClient {
	private final Logging logging;

	public LogClient(Logging logging) {
		this.logging = logging;
	}

	public void doWork(final int count) {
		if (count % 2 == 0) {
			logging.write("Even number: " + count);
		}
	}
}
