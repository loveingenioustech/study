package test.elance;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Scanner;

/**
 * 
Write a program which will take the year (yyyy) and the numeric sequence of the month (0-11) as its input. 
	The program will return the day on which the 28th of that particular month and year falls. 
	The input can consist of two year-month combinations, one combination per line.

The numeric sequence of months is as follows:

0 – Jan
1 – Feb
2 – March
and so on......

The format for supplying the input is:

1999-5

Where 1999 is the year and 5 is the numeric sequence of the month (corresponding to June). The program should display the day on which June 28, 1999 fell, and in this case the output will be MONDAY.

The output should be displayed in uppercase letters.

Suppose the following INPUT sequence is given to the program:

1999-5
1998-6

Then the output should be:

MONDAY
TUESDAY 
 *
 */
public class Test8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		getDay(a);
		getDay(b);
	}

	public static void getDay(String in) {
		String yearmon[] = in.split("-");
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(yearmon[0]), Integer.parseInt(yearmon[1]), 28);
		int val = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(new DateFormatSymbols().getWeekdays()[val]
				.toUpperCase());
	}

}
