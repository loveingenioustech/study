package bookmanager.admin;

import java.util.ArrayList;
import java.util.List;

import bookmanager.server.beans.BooklookUser;
import bookmanager.server.services.PasswordEncrypter;
import bookmanager.server.services.Persistence;

public class UserAdmin {

	public static void adduser(String[] args) {
		if (args == null || args.length < 4) {
			System.out.println("addusers: usage");
			System.out.println("admin addusers username password usertype");
			System.out.println("  where usertype is one of 'admin' or 'user'");
			System.exit(0);
		}
		BooklookUser booklookUser = new BooklookUser();
		booklookUser.setUsername(args[1]);
		booklookUser.setPassword(PasswordEncrypter.encrypt(args[2]));
		booklookUser.setUsertype(args[3]);
		Persistence.getInstance().addUser(booklookUser);
	}

	@SuppressWarnings("unchecked")
	public static void listusers() {
		List<BooklookUser> booklookUsers = new ArrayList<BooklookUser>();
		booklookUsers = Persistence.getInstance().getAllUsers();
		System.out.println("Current users:");
		for (int i = 0; i < booklookUsers.size(); i++) {
			BooklookUser booklookUser = booklookUsers.get(i);
			System.out.println(booklookUser.getUsername() + " "
					+ booklookUser.getPassword() + " "
					+ booklookUser.getUsertype());
		}
	}
}
