package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static util.Print.*;

public class RegexAPIDemo {

	public static void main(String[] args) {
		RegexAPIDemo demo = new RegexAPIDemo();

		demo.create();
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

}
