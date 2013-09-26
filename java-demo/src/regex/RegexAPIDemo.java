package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static util.Print.*;

public class RegexAPIDemo {

	public static void main(String[] args) {
		RegexAPIDemo demo = new RegexAPIDemo();

		// demo.create();

		// demo.options();

		demo.position();
	}

	private void create() {

		try {
			Pattern regex = Pattern.compile("He");

			Matcher regexMatcher = regex.matcher("Hello");
			print(regexMatcher.find());

			regexMatcher.reset("HaHa");
			print(regexMatcher.find());

		} catch (PatternSyntaxException ex) {
			// Syntax error in the regular expression
		}
	}

	private void options() {
		Pattern regex = Pattern.compile("Hello.You", Pattern.COMMENTS
				| Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE
				| Pattern.DOTALL | Pattern.MULTILINE);

		Matcher regexMatcher = regex.matcher("Hello\nYou!!!");
		print(regexMatcher.find());

	}

	private void position() {
		int matchStart, matchLength = -1;
		Pattern regex = Pattern.compile("\\d+");
		Matcher regexMatcher = regex.matcher("Hello 12345!!!");
		if (regexMatcher.find()) {
			matchStart = regexMatcher.start();
			matchLength = regexMatcher.end() - matchStart;
			print("matchStart: " + matchStart);
			print("matchLength: " + matchLength);
		}

	}
}
