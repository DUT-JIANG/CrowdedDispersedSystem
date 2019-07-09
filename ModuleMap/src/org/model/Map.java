package org.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

import org.model.SchemeSubmit.Tools.ApiRequest;
import org.model.SchemeSubmit.Tools.ApiReturn;
import org.model.SchemeSubmit.Tools.point;
import org.model.SchemeSubmit.Tools.settings;
import org.model.SchemeSubmit.Tools.result.Route;

public class Map {
	private static final Collection<? extends point> PointComparator = null;
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
	public static point[] getAllJunction(point src,point dst) {
	
		point tmp1 = new point(src.x,dst.y);
		point tmp2 = new point(dst.x,src.y);
		point [] p1 = Map.getJunctions(src, dst);
		point [] p2 = Map.getJunctions(src, tmp1);
		point [] p3 = Map.getJunctions(src, tmp2);
		point [] p4 = Map.getJunctions(tmp1, dst);
		point [] p5= Map.getJunctions(tmp2, dst);
		point [] p6= Map.getJunctions(tmp1, tmp2);
		HashSet<point> hs = new HashSet<point>();
		for(int i=1;i<p1.length;i++) {
			System.out.print("[Generating Pathes]");
			System.out.print(i);
			System.out.print('\\');
			System.out.println(p1.length);
			point [] Points = Map.getJunctions(p1[i], tmp1);
			point [] Points2 = Map.getJunctions(p1[i], tmp2);
			for(int i1=1;i1<Points.length;i1++) {
				hs.add(Points[i1]);
			}

			for(int i1=1;i1<Points2.length;i1++) {
				hs.add(Points2[i1]);
			}
		}
		for(int i=1;i<p2.length;i++) {
			System.out.print("[Generating Pathes]");
			System.out.print(i);
			System.out.print('\\');
			System.out.print(p2.length);
			System.out.print("point num :");
			System.out.println(hs.size());
			for(int j=1;j<p5.length;j++) {
				point[] points = Map.getJunctions(p2[i], p5[j]);
				for(int i1=1;i1<points.length;i1++) {
					hs.add(points[i1]);
				}
			}
		}

		for(int i=1;i<p3.length;i++) {
			System.out.print("[Generating Pathes]");
			System.out.print(i);
			System.out.print('\\');
			System.out.print(p3.length);
			System.out.print("point num :");
			System.out.println(hs.size());
			for(int j=1;j<p4.length;j++) {
				point[] points = Map.getJunctions(p2[i], p5[j]);
				for(int i1=1;i1<points.length;i1++) {
					hs.add(points[i1]);
				}
			}
		}
		System.out.println("[Finnishing]");
		point [] ans = (point[]) hs.toArray(new point[hs.size()]);
		System.out.println(ans.length);
		for(int i=1;i<ans.length;i++) {
			System.out.print("new BMap.Point(");
			System.out.print(ans[i].toString2());
			System.out.println("),");
		}
		return ans;
		
	}
	
}
