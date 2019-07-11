package org.model.SchemeMake.Units;

import java.text.DecimalFormat;

import org.model.SchemeMake.Tools.settings;


public class point implements Comparable{
	
	public double x, y;
	@Override 
    public boolean equals(Object st) 
    { 
		double x1 = this.x;
		double y1 = this.y;
		double x2 = ((point)st).x;
		double y2 = ((point)st).y;
		
		double distance = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
		return distance <(double)50;
    }
	public point(double x, double y) {
		this.x = 0;
		this.y = 0;
		this.x = x;
		this.y = y;
	}

	point() {
		this.x = 0;
		this.y = 0;
	}

	point(point a) {
		this.x = a.x;
		this.y = a.y;
	}

	public point(String json) {
		if (settings.DEBUG_MODE) {
			System.out.print("[point debug - json]");
			System.out.print(json);
		}
		String s1;
		String s2;
		if (json.charAt(0) == '{') {
			s1 = settings.findAttribute(json, "lng");
			s2 = settings.findAttribute(json, "lat");
		} else {
			int pos = json.indexOf(',');
			s1 = json.substring(0, pos);
			s2 = json.substring(pos + 1, json.length());
		}

		x = Float.parseFloat(s1);
		y = Float.parseFloat(s2);
		if (settings.DEBUG_MODE) {
			System.out.print(x);
			System.out.print(',');
			System.out.println(y);
		}
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("0.000000");
		String ans = df.format(x) + "," + df.format(y);
		return ans;
	}
	public String toString2() {
		DecimalFormat df = new DecimalFormat("0.000000");
		String ans = df.format(y) + "," + df.format(x);
		return ans;
	}
	public point clone(point s) {
		point p = new point(s.x,s.y);
		return p;
	}
	public point clone() {
		point p = new point(this.x,this.y);
		return p;
	}

	@Override
	public int compareTo(Object o) {
		double x1 = this.x;
		double y1 = this.y;
		double x2 = ((point)o).x;
		double y2 = ((point)o).y;
		
		double distance = getDistance(this.x,this.y,((point)o).x,((point)o).y);
		if(distance<10) {
			return 0;
		}
		long lx1 = (int)(x1*1000000);
		long ly1 = (int)(y1*1000000);
		long lx2 = (int)(x2*1000000);
		long ly2 = (int)(y2*1000000);
		return (int) (100*(lx1-lx2)+(ly1-ly2));
	}
	
	private static double EARTH_RADIUS = 6378.137;//地球半径
	private static double rad(double d)
	{
	   return d * Math.PI / 180.0;
	}
    public static double getDistance(double lat1, double lng1, double lat2,double lng2) {  
        double radLat1 = rad(lat1);  
        double radLat2 = rad(lat2);  
        double a = radLat1 - radLat2;  
        double b = rad(lng1) - rad(lng2);  
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)  
                + Math.cos(radLat1) * Math.cos(radLat2)  
                * Math.pow(Math.sin(b / 2), 2)));  
        s = s * EARTH_RADIUS;  
        s = Math.round(s * 10000d) / 10000d;  
        s = s*1000;  
        return s;  
    }
}

