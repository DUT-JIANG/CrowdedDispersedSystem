package System.Tools;
import com.google.gson.*;
public class settings {
	public static int MAX_POINT = 3000;
	public static String getJSON(String s) {
		String JSON = s.substring(s.indexOf('{'),s.length());
		
		return JSON;
	}
}
