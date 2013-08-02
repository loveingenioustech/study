package dynamic;

/**
 * @author Robin
 *
 * javac dynamic\*.java
 */
public class DynamicDemo {

	public static void main(String[] args) {
//		System.out.println("Interface Constant's HUNT = " + Constant.HUNT);

		System.out.println("Interface Constant's HUNT = " + ConstantClass.getHunt());
	}

}
