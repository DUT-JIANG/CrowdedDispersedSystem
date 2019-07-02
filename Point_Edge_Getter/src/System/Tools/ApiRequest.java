package System.Tools;

import System.*;
public class ApiRequest {
	private point src;
	private point dst;
	private String DriveURL="http://api.map.baidu.com/direction/v2/driving";
	private String AK = "ak=HhS1Knir0GdBAnQtqwY0ABpjBV2KbtaW";
	private String origin;
	private String destination;
	private String params;
	private ApiReturn ret;
	public ApiRequest(point src,point dst){
		this.src=src;
		this.dst=dst;
		origin="origin="+this.src.toString();
		destination="destination="+this.dst.toString();
		
	}
	public String CulculatePath_Drive() {
		params = origin+"&"+destination+"&"+AK;
		return settings.getJSON(HttpRequest.sendGet(DriveURL, params));
	}
	
}
