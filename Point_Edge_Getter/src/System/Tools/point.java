package System.Tools;

import java.text.DecimalFormat;

public class point {
	public double x,y;
	public point(double x,double y){
		this.x =x;
		this.y=y;
	}
	point(){
		this.x =0;
		this.y=0;
	}

	point(point a){
		this.x =a.x;
		this.y=a.y;
	}
	public String toString(){
		DecimalFormat df = new DecimalFormat("0.000000");
		String ans = df.format(x)+","+df.format(y);
		return ans;
	}
}
