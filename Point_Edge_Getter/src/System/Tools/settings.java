package System.Tools;
public class settings {
	public static int MAX_POINT = 3000;
	public final static boolean DEBUG_MODE=false;
	public static String getJSON(String s) {
		String JSON = s.substring(s.indexOf('{'),s.length());
		
		return JSON;
	}
}
