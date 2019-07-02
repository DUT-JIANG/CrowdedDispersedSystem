package System;

public class point {
	public double x,y;
	point(double x,double y){
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
}
