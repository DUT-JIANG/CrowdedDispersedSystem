package org.model.SchemeMake.Tools.result;

import org.model.SchemeMake.Tools.settings;
import org.model.SchemeMake.Units.*;
public class step {
	private int leg_index;
	private int direction;
	private float distance;
	private String road_name;
	private int road_type;
	private int toll;
	private float toll_distance;
	private String toll_gate_name;
	private point toll_gate_location;
	private point start_location;
	private point end_location;
	private Condition[] traffic_condition;
	public Path path;
	
	public step(String json) {
		if(settings.DEBUG_MODE) {
			System.out.print("[step debug]");
			System.out.println(json);
		}
		String condition = settings.findAttribute(json, "traffic_condition");
		int len = settings.getJSONLen(condition);
		traffic_condition = new Condition[len+1];
		for(int i=1;i<=len;i++) {
			traffic_condition[i]=new Condition(settings.getByIndex(condition, i));
		}
		leg_index = Integer.parseInt(settings.findAttribute(json, "leg_index"));
		direction = Integer.parseInt(settings.findAttribute(json, "direction"));
		distance = Float.parseFloat(settings.findAttribute(json, "distance"));
		road_type = Integer.parseInt(settings.findAttribute(json, "road_type"));
		toll = Integer.parseInt(settings.findAttribute(json, "toll"));
		toll_distance = Float.parseFloat(settings.findAttribute(json, "toll_distance"));
		start_location = new point(settings.findAttribute(json, "start_location"));
		end_location = new point(settings.findAttribute(json, "start_location"));
		String strPath = settings.findAttribute(json, "path");
		road_name = settings.findAttribute(json, "road_name");
		path = new Path(strPath);
	}
	public int pointNum() {
		return path.pointNum();
	}
	public Path getPath() {
		return path;
	}
	public String getRoadName() {
		return road_name;
	}
	public point[] getPoint() {
		point[] ret = path.getPoints();
		if(settings.DEBUG_MODE) {
			for(int i=1;i<ret.length;i++) {
				System.out.print("[point test in step]");
				System.out.println(ret[i].toString());
			}
		}
		return ret;
	}
	
}
