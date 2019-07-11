package tester;

import java.util.regex.Pattern;

public class tester {

	public static void main(String[] args) {
		String content = "13315462138";
		String pattern = "(1[3-9]\\d{9})";
//		if(content.length()!=6) {
//			return ;
//		}
		if(Pattern.matches(pattern, content)) {
			System.out.println("asdasdasd");
		}
		else
		System.out.println("wrong");
	}
}
