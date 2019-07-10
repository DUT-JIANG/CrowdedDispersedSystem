package tester;

import java.util.regex.Pattern;

public class tester {

	public static void main(String[] args) {
		String content = "1234";
		String pattern = "\\d{4}";
//		if(content.length()!=6) {
//			return ;
//		}
		if(Pattern.matches(pattern, content)) {
			System.out.println("asdasdasd");
		}
		System.out.println("wrong");
	}
}
