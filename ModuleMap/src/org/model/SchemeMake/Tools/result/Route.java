package org.model.SchemeMake.Tools.result;

import org.model.SchemeMake.Tools.settings;
import org.model.SchemeMake.Units.*;
import org.model.SchemeMake.Units.*;
public class Route {
	private point src;
	private point dst;
	private String tag;
	private Condition[] traffic_condition;
	private int distance = 0;
	private int duration = 0;
	private int taxi_fee = 0;
	private int toll = 0;
	private int toll_distance = 0;
	private step[] steps;

	public Route(String json) {
		if (settings.DEBUG_MODE) {
			System.out.print("[Route Debug]");
			System.out.println(json);
		}
		String origin = settings.findAttribute(json, "origin");
		String destination = settings.findAttribute(json, "destination");
		tag = settings.findAttribute(json, "tag");
		String Steps = settings.findAttribute(json, "steps");
		int len = settings.getJSONLen(Steps);
		steps = new step[len + 1];
		for (int i = 1; i <= len; i++) {
			steps[i] = new step(settings.getByIndex(Steps, i));
		}
		distance = Integer.parseInt(settings.findAttribute(json, "distance"));
		duration = Integer.parseInt(settings.findAttribute(json, "duration"));
		taxi_fee = Integer.parseInt(settings.findAttribute(json, "taxi_fee"));
		toll = Integer.parseInt(settings.findAttribute(json, "toll"));
		toll_distance = Integer.parseInt(settings.findAttribute(json, "toll_distance"));
	}

	public int pointNum() {
		int ret = 0;
		for (int i = 1; i < steps.length; i++) {
			ret += steps[i].pointNum();
		}
		return ret;
	}

	public point[] getPoint() {
		int len = 1;
		point[] ret = null;
		for (int i = 1; i < steps.length; i++) {
			len += steps[i].getPoint().length;
		}
		ret = new point[len];
		int index=1;
		for (int i = 1; i < steps.length; i++) {
			point[] tmp = steps[i].getPoint();
			for(int j = 1;j<tmp.length;j++) {
				if(tmp[j]!=null)
					ret[index++]=tmp[j];
			}
		}
		point[] tmp = new point[index];
		for(int i=1;i<index;i++) {
			tmp[i]=ret[i].clone();
		}
		return tmp;
	}

	public step[] getSteps() {
		return steps;
	}

	public point[] getJunctions() {
		int len = steps.length;
		point[] ret = new point[len - 1];
		for (int i = 1; i < len - 1; i++) {
			if (settings.DEBUG_MODE) {
				System.out.println(steps[i].getRoadName());
			}
			int len1 = steps[i].getPath().getPoints().length;
			point tmp = steps[i].getPath().getPoints()[len1 - 1];
			ret[i] = new point(tmp.x, tmp.y);
		}
		return ret;
	}
}
