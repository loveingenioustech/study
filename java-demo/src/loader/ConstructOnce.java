package loader;

public class ConstructOnce {
	static private boolean runOnce = false;

	public ConstructOnce() {
		System.out.println(this);
		
		if (runOnce)
			throw new IllegalStateException("run twice");
		runOnce = true;
	}
}
