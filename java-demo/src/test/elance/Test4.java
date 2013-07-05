/**
 *
Ross is an event organizer. He has received data regarding the participation of employees in two different events. Some employees have participated in only one event and others have participated in both events. Ross now needs to count the number of employees who have taken part in both events. The records received by Ross consist of employee ids, which are unique. Write a program that accepts the employee ids participating in each event (the first line relates to the first event and the second line relates to the second event). The program should print the number of common employee ids in both the events.

Suppose the following input is given to the program, where each line represents a different event:
1001,1002,1003,1004,1005
1106,1008,1005,1003,1016,1017,1112

Now the common employee ids are 1003 and 1005, so the program should give the output as:
2

IMPORTANT NOTES - READ CAREFULLY:

1. Your solution should assume console input
2. Your solution should contain class name as Main, as the solution will be compiled as Main.java

 *
 */
package test.elance;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String strarr[] = { "", "" };
		strarr[0] = in.nextLine();
		strarr[1] = in.nextLine();
		ArrayList<Integer> list[] = new ArrayList[2];
		for (int i = 0; i < strarr.length; i++) {
			StringTokenizer stk = new StringTokenizer(strarr[i], ",");
			list[i] = new ArrayList<Integer>();
			while (stk.hasMoreTokens()) {
				list[i].add(Integer.parseInt(stk.nextToken()));
			}
		}
		ArrayList<Integer> listcommon = new ArrayList<Integer>(list[1]);
		listcommon.retainAll(list[0]);
		System.out.println(listcommon.size());
	}

}
