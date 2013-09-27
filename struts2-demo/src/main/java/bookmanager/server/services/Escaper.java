package bookmanager.server.services;

public class Escaper {
	public static String escapeCSV(String aString) {
		aString = aString.replace(",", "&#044;");
		return aString.replace("\n", " ");
	}
}
