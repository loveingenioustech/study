/**
 *
 Write a program that accepts 10 student records (roll number and score) and prints them in decreasing
order of scores. In case there are multiple records pertaining to the same student, the program should 
choose a single record containing the highest score. The program should be capable of accepting a multi-line
input. Each subsequent line of input will contain a student record, that is, a roll number and a score
(separated by a hyphen). The output should consist of the combination of roll number and corresponding
score in decreasing order of score.

INPUT to program

1001-40
1002-50
1003-60
1002-80
1005-35
1005-55
1007-68
1009-99
1009-10
1004-89

OUTPUT from program

1009-99
1004-89
1002-80
1007-68
1003-60
1005-55
1001-40

 *
 */
package test.elance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test10 {

	public static void main(String args[]) {
		Test10 test10 = new Test10();

		test10.test();
	}

	private void test() {
		try {
			Scanner in = new Scanner(System.in);
			ArrayList<Student> stud = new ArrayList<Student>();
			int c = 0;
			while (c < 10) {
				String k = in.nextLine();
				StringTokenizer stk = new StringTokenizer(k, "-");
				Student st = new Student();
				st.id = Integer.parseInt(stk.nextToken());
				st.score = Integer.parseInt(stk.nextToken());

				if (c > 1) {
					Student stDup = findStudentByid(st.id, stud);
					if (stDup != null) {
						if (st.score > stDup.score) {
							stud.add(st);
							stud.remove(stDup);
						}
					} else {
						stud.add(st);
					}
				} else
					stud.add(st);
				c++;
			}
			Collections.sort(stud, new Comparator<Student>() {
				public int compare(Student o1, Student o2) {
					return o2.score - o1.score;
				}
			});
			for (Student stt : stud) {
				System.out.println(stt.id + "-" + stt.score);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	static Student findStudentByid(int id, ArrayList<Student> list) {
		for (Student s : list) {
			if (s.id == id)
				return s;
		}
		return null;
	}

	class Student {
		int id;
		int score;

		public Student() {

		}

		public Student(int id, int score) {
			super();
			this.id = id;
			this.score = score;
		}

	}
}
