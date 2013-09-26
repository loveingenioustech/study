package regex;

import static util.Print.print;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexAPIDemo {

	public static void main(String[] args) {
		RegexAPIDemo demo = new RegexAPIDemo();

		// demo.create();

		// demo.options();

		// demo.position();

		demo.nest();
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

	private void nest() {
		List<String> resultList = new ArrayList<String>();
		Pattern outerRegex = Pattern.compile("<b>(.*?)</b>", Pattern.DOTALL);
		Pattern innerRegex = Pattern.compile("\\d+");

		String subjectString = "1 <b>2</b> 3 4 <b>5 6 7</b> HaHa";

		Matcher outerMatcher = outerRegex.matcher(subjectString);
		Matcher innerMatcher = innerRegex.matcher(subjectString);
		while (outerMatcher.find()) {
			innerMatcher.region(outerMatcher.start(), outerMatcher.end());
			while (innerMatcher.find()) {
				resultList.add(innerMatcher.group());
			}
		}

		for (String str : resultList) {
			print(str);
		}

	}
}
