package bookmanager.admin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import bookmanager.server.beans.Book;
import bookmanager.server.services.Persistence;

public class BookAdmin {
	public static void populateWithTestBookData(String[] args) {
		if (args == null || args.length < 2) {
			System.out.println("args.length=" + args.length);
			System.out.println("popdb: usage");
			System.out.println("admin popdb filename");
			System.out
					.println("  where filename is the path a file of csv-separated records in the order of catalog-number, title, author, copyright, and binding");
			System.exit(0);
		}

		File file = new File(args[1]);
		if (!file.canRead()) {
			System.out.println(args[1] + " not found.");
			System.exit(0);
		}

		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					file));
			String readline;
			while ((readline = bufferedReader.readLine()) != null) {
				String[] columns = readline.split(",");
				if (columns.length != 5) {
					continue;
				}
				int copyrightInt;
				try {
					copyrightInt = Integer.parseInt(columns[3]);
				} catch (NumberFormatException numberFormatException) {
					copyrightInt = 0;
				}
				Book book = new Book();
				book.setCatalog(columns[0]);
				book.setTitle(columns[1]);
				book.setAuthor(columns[2]);
				book.setCopyright(copyrightInt);
				book.setBinding(columns[4]);
				Persistence.getInstance().addBook(book);
			}
			bufferedReader.close();
		} catch (IOException e) {
			System.err.println("Fatal IO error, aborting. ");
			System.exit(1);
		}
	}
}
