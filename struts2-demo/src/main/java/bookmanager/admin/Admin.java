package bookmanager.admin;

public class Admin {
	public static void main(String[] args) {
		if (args == null || args.length < 1) {
			printUsage();
			System.exit(0);
		}

		if (args[0].trim().equalsIgnoreCase("adduser")) {
			UserAdmin.adduser(args);
			System.exit(0);
		}
		if (args[0].trim().equalsIgnoreCase("listusers")) {
			UserAdmin.listusers();
			System.exit(0);
		}
		if (args[0].trim().equalsIgnoreCase("popdb")) {
			BookAdmin.populateWithTestBookData(args);
			System.exit(0);
		}
		printUsage();
	}

	private static void printUsage() {
		System.out.println("admin usage:");
		System.out.println("  admin adduser username password usertype");
		System.out.println("  admin listusers");
		System.out.println("  admin popdb");
	}
}
