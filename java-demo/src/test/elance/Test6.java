package test.elance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 *         Write a program to calculate the distance travelled by a car at different time intervals.<br>
 *         The initial velocity of the car is 36 km/hr and the constant acceleration is 5 m/s2.
 * 
 *         The formula to calculate distance is:
 * 
 *         Distance Travelled = u*t+((a*t*t)/2) where, u = initial velocity of the car (36 km/hr) a = acceleration of
 *         the car (5 m/s2) t = time duration in seconds
 * 
 *         The program should accept 2 time intervals as the input (one time interval per line) and print the distance
 *         travelled in meters by the car (one output per line).
 * 
 *         Definitions: ------------ 1 kilometer = 1000 meters 1 hour = 3600 seconds
 * 
 *         Let us suppose following are the inputs supplied to the program
 * 
 *         10 8
 * 
 *         Then the output of the program will be
 * 
 *         350 240
 *
 */
public class Test6 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(
				System.in));
		double t1 = Double.parseDouble(bufferRead.readLine());
		double t2 = Double.parseDouble(bufferRead.readLine());

		System.out.println(getDistance(t1));
		System.out.println(getDistance(t2));

	}

	public static int getDistance(double t) {
		double u = 36 * 1000 / 3600;// initial velocity of the /(36 km/hr)
		double a = 5; // m/s2
		return (int) (u * t + ((a * t * t) / 2));
	}

}
