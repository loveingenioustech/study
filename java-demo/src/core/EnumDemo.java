package core;

import util.*;

enum Activity {
	SITTING, LYING, STANDING, HOPPING, RUNNING, DODGING, JUMPING, FALLING, FLYING
}

public class EnumDemo {
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++)
			System.out.print(Enums.random(Activity.class) + " ");
	}
}