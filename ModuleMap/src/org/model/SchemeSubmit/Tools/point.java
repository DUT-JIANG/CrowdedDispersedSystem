package org.model.SchemeSubmit.Tools;

import java.text.DecimalFormat;


public class point implements Comparable{
	@Override 
    public boolean equals(Object st) 
    { 
		return this.x==((point)st).x&&this.y==((point)st).y;
    }
	public double x, y;

	public point(double x, double y) {
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
		return (int) ((this.x-((point)o).x)*(this.y-((point)o).y));
	}
}

