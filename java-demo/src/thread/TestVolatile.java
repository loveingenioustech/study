package thread;

/*
 * 
 With volatile keyword
 Incrementing MY_INT to: 1
 Got Change for MY_INT : 1
 Incrementing MY_INT to: 2
 Got Change for MY_INT : 2
 Got Change for MY_INT : 3
 Incrementing MY_INT to: 3
 Incrementing MY_INT to: 4
 Got Change for MY_INT : 4
 Incrementing MY_INT to: 5
 Got Change for MY_INT : 5


 Without the volatile keyword the output is :
 1.Incrementing MY_INT to 1
 2.Incrementing MY_INT to 2
 3.Incrementing MY_INT to 3
 4.Incrementing MY_INT to 4
 5.Incrementing MY_INT to 5
 .....And the change listener loop infinitely... 


 ExplanationSo what happens? 
 Each thread has its own stack, and so its own copy of variables it can access. 
 When the thread is created, it copies the value of all accessible variables in its own memory. 
 The volatile keyword is used to say to the jvm "Warning, this variable may be modified in an other Thread". 
 Without this keyword the JVM is free to make some optimizations, like never refreshing those local copies in some threads. 
 The volatile force the thread to update the original variable for each variable. 
 The volatile keyword could be used on every kind of variable, either primitive or objects! Maybe the subject of another article, more detailed...
 
 Never used volatile and never met this problem...
 Like all threads issues, it happens under specials circumstances. 
 Really special for this one... 
 My example has big chances to show mainly because the ChangeListener thread is busy, thanks to the loop, and the JVM consider that this thread has no time for updating the local variables. 
 Executing some synchronized methods or adding an other variable which is volatile (or even executing some simple lines of code) could modify the JVM behavior and "correct" this problem...

 * 
 * 
 * 
 */
public class TestVolatile {
	private static volatile int MY_INT = 0;

	// private static int MY_INT = 0;

	public static void main(String[] args) {
		new ChangeListener().start();
		new ChangeMaker().start();
	}

	static class ChangeListener extends Thread {
		@Override
		public void run() {
			int local_value = MY_INT;
			while (local_value < 5) {
				if (local_value != MY_INT) {
					System.out.println("Got Change for MY_INT : " + MY_INT);

					local_value = MY_INT;
				}
			}
		}
	}

	static class ChangeMaker extends Thread {
		@Override
		public void run() {

			int local_value = MY_INT;
			while (MY_INT < 5) {
				MY_INT = ++local_value;
				System.out.println("Incrementing MY_INT to: " + local_value);

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
