package org.model.SchemeMake.PathApi;

import org.model.*;
import org.model.SchemeMake.Units.*;
public class PathRequest {
	private point src;
	private point dst;
	private String DriveURL="http://api.map.baidu.com/direction/v2/driving";
	private String AK = "ak=HhS1Knir0GdBAnQtqwY0ABpjBV2KbtaW";
	private String origin;
	private String destination;
	private String params;
	private PathReturn ret;
	public PathRequest(point src,point dst){
		this.src=src;
		this.dst=dst;
		origin="origin="+this.src.toString();
		destination="destination="+this.dst.toString();
		
	}
	public String CulculatePath_Drive() {
		params = origin+"&"+destination+"&"+"alternatives=1"+"&"+AK;
		if(settings.DEBUG_MODE) {
			System.out.print("[Requester Debug]");
			System.out.println(params);
		}
		return settings.getJSON(HttpRequest.sendGet(DriveURL, params));
	}
	public String CulculatePath_Drive(point src,point dst) {
		this.src=src;
		this.dst=dst;
		origin="origin="+this.src.toString();
		destination="destination="+this.dst.toString();
		
		params = origin+"&"+destination+"&"+AK;
		if(settings.DEBUG_MODE) {
			System.out.print("[Requester Debug]");
			System.out.print(params);
		}
		return settings.getJSON(HttpRequest.sendGet(DriveURL, params));
	}
	
}
