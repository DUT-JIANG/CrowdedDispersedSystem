package org.model.SchemeMake.EncodingApi;

import org.model.SchemeMake.PathApi.HttpRequest;
import org.model.SchemeMake.PathApi.PathReturn;
import org.model.SchemeMake.PathApi.settings;
import org.model.SchemeMake.Units.point;

public class EncodingRequest {
	private static String PathURL="http://api.map.baidu.com/geocoding/v3/";
	private String address;
	private static String AK = "HhS1Knir0GdBAnQtqwY0ABpjBV2KbtaW";
	private static String output = "json";
	private static String params;
	public EncodingRequest(String address){
		this.address = address;
	}
	public String SendRequest() {
		params = "address="+address+"&"+"ak="+AK+"&"+"output="+output;
		return settings.getJSON(HttpRequest.sendGet(PathURL, params));
	}
	public static String SendRequest(String address) {
		params = "address="+address+"&"+"ak="+AK+"&"+"output="+output;
		return settings.getJSON(HttpRequest.sendGet(PathURL, params));
	}
}
