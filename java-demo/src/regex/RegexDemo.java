package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexDemo {
	public static void main(String[] args) {

		RegexDemo regexDemo = new RegexDemo();

		// Static Test
//		regexDemo.testZipCode();

//		regexDemo.testExtractMonth();

//		regexDemo.testTranslateUBB();

		// Dynamic Test
		regexDemo.test();
	}

	private void test() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter pattern: ");
		String patternString = in.nextLine();

		Pattern pattern = null;
		try {
			pattern = Pattern.compile(patternString);
		} catch (PatternSyntaxException e) {
			System.out.println("Pattern syntax error");
			System.exit(1);
		}

		while (true) {
			System.out.println("Enter string to match: ");
			String input = in.nextLine();
			if (input == null || input.equals(""))
				return;
			Matcher matcher = pattern.matcher(input);
			if (matcher.matches()) {
				System.out.println("Match");
				int g = matcher.groupCount();
				if (g > 0) {
					for (int i = 0; i < input.length(); i++) {
						for (int j = 1; j <= g; j++)
							if (i == matcher.start(j))
								System.out.print('(');
						System.out.print(input.charAt(i));
						for (int j = 1; j <= g; j++)
							if (i + 1 == matcher.end(j))
								System.out.print(')');
					}
					System.out.println();
				}
			} else
				System.out.println("No match");
		}

	}

	private void testTranslateUBB() {
		String ubb = "[URL]http://www.codecademy.com/learn[/URL]\n[IMG]test.jpg[/IMG]\n[I]Open Source![/I]\n[B]Important![/B]\n";

		String html = ubb;

		html = replace("\\[URL\\](.+)\\[/URL\\]", html,
				"<A href=$1 target=_blank>$1</A>");

		html = replace("\\[IMG\\](.+)\\[/IMG\\]", html, "<IMG src=$1 />");

		html = replace("\\[I\\](.+)\\[/I\\]", html, "<i>$1</i>");

		html = replace("\\[B\\](.+)\\[/B\\]", html, "<b>$1</b>");

		System.out.println(html);
	}

	private String replace(String regex, String input, String replacement) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);

		return m.replaceAll(replacement);
	}

	private void testExtractMonth() {
		String regex = "([a-zA-Z]+)\\s+[0-9]{1,2},\\s*[0-9]{4}";
		String str = "June 26, 1951";

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);

		if (!m.find()) {
			System.out.println("Error Date Format!");
			return;
		}

		System.out.println(m.group(1));
	}

	private void testZipCode() {
		System.out.println(Pattern.matches("[0-9]{6}", "518067"));
		System.out.println(Pattern.matches("\\d{6}", "51806a"));
	}

}
