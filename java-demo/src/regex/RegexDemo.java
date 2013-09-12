package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {	
	public static void main(String[] args) {

		RegexDemo regexDemo = new RegexDemo();

		regexDemo.testZipCode();

		regexDemo.testExtractMonth();
		
		regexDemo.testTranslateUBB();
	}



	private void testTranslateUBB() {
		String ubb = "[URL]http://www.codecademy.com/learn[/URL]\n[IMG]test.jpg[/IMG]\n[I]Open Source![/I]\n[B]Important![/B]\n";
		
		String html = ubb;
		
		html = replace("\\[URL\\](.+)\\[/URL\\]", html, "<A href=$1 target=_blank>$1</A>");
		
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
