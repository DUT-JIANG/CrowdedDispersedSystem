package System;

import System.Tools.settings;

public class Map {
	public point src,dst;
	public point[] tmp;
	public point[] ans;
	Map(point src,point dst){
		this.src = src;
		this.dst = dst;
		tmp = new point [3];
		tmp[1]=new point(src.x,dst.y);
		tmp[2]=new point(dst.x,src.y);
		ans=new point[settings.MAX_POINT];
		for(int i=0;i<settings.MAX_POINT;i++) {
			ans[i]=new point(0.0,0.0);
		}
		
	}
	
}
