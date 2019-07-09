package System;

import System.Tools.ApiRequest;
import System.Tools.ApiReturn;
import System.Tools.point;
import System.Tools.settings;
import System.Tools.result.Route;

public class Map {
	public point src,dst;
	public point[] tmp;
	public point[] ans;
	public Map(point src,point dst){
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
	public static point[] getJunctions(point src,point dst) {
		ApiRequest apr = new ApiRequest(src,dst);
		
		String JSON = apr.CulculatePath_Drive();
		if(settings.DEBUG_MODE) {
			System.out.println(JSON);
		}
		ApiReturn ret = new ApiReturn(JSON);
		
		Route[] rot = ret.getRoutes();
		point[] p = rot[1].getJunctions();
		
		
		return p;

	}
	
}
