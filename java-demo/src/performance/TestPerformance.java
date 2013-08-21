package performance;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class TestPerformance {

	public static void main(String[] args) {
		TestPerformance testPerformance = new TestPerformance();

		testPerformance.getMemoryInfo();

		testPerformance.getCpuInfo();
	}

	private void getCpuInfo() {

		int availableProcessors = ManagementFactory.getOperatingSystemMXBean()
				.getAvailableProcessors();
		long lastSystemTime = System.nanoTime();
		long lastProcessCpuTime = 0;

		if (ManagementFactory.getOperatingSystemMXBean() instanceof OperatingSystemMXBean) {
			lastProcessCpuTime = ((com.sun.management.OperatingSystemMXBean) ManagementFactory
					.getOperatingSystemMXBean()).getProcessCpuTime();
		}

		long systemTime = System.nanoTime();
		long processCpuTime = 0;

		if (ManagementFactory.getOperatingSystemMXBean() instanceof OperatingSystemMXBean) {
			processCpuTime = ((com.sun.management.OperatingSystemMXBean) ManagementFactory
					.getOperatingSystemMXBean()).getProcessCpuTime();
		}

		double cpuUsage = (double) (processCpuTime - lastProcessCpuTime)
				/ (systemTime - lastSystemTime);

		lastSystemTime = systemTime;
		lastProcessCpuTime = processCpuTime;

		System.out.println("cpuUsage / availableProcessors: " + cpuUsage
				/ availableProcessors);
	}

	private void getMemoryInfo() {
		/* Total number of processors or cores available to the JVM */
		System.out.println("Available processors (cores): "
				+ Runtime.getRuntime().availableProcessors());

		/* Total amount of free memory available to the JVM */
		System.out.println("Free memory (bytes): "
				+ Runtime.getRuntime().freeMemory());

		/* This will return Long.MAX_VALUE if there is no preset limit */
		long maxMemory = Runtime.getRuntime().maxMemory();
		/* Maximum amount of memory the JVM will attempt to use */
		System.out.println("Maximum memory (bytes): "
				+ (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));

		/* Total memory currently in use by the JVM */
		System.out.println("Total memory (bytes): "
				+ Runtime.getRuntime().totalMemory());

		/* Get a list of all filesystem roots on this system */
		File[] roots = File.listRoots();

		/* For each filesystem root, print some info */
		for (File root : roots) {
			System.out.println("File system root: " + root.getAbsolutePath());
			System.out.println("Total space (bytes): " + root.getTotalSpace());
			System.out.println("Free space (bytes): " + root.getFreeSpace());
			System.out
					.println("Usable space (bytes): " + root.getUsableSpace());
		}
	}

}
