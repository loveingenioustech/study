package bookmanager.server.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncrypter {
	public static String encrypt(String password) {
		MessageDigest messageDigester;
		try {
			messageDigester = MessageDigest.getInstance("SHA");
			messageDigester.reset();
			messageDigester.update(password.getBytes());

			byte messageDigest[] = messageDigester.digest();

			StringBuffer digestString = new StringBuffer();
			for (int i = 0; i < messageDigest.length; i++) {
				digestString.append(Integer
						.toHexString(0xFF & messageDigest[i]));
			}
			return digestString.toString();
		} catch (NoSuchAlgorithmException e) {
			return password;
		}
	}
}
