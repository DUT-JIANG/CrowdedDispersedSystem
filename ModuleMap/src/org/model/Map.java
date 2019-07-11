package org.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;
import java.util.TreeSet;

import org.model.SchemeMake.PathApi.PathRequest;
import org.model.SchemeMake.PathApi.PathReturn;
import org.model.SchemeMake.PathApi.settings;
import org.model.SchemeMake.PathApi.result.Route;
import org.model.SchemeMake.Units.*;

public class Map {
	private static final Collection<? extends point> PointComparator = null;
	public point src,dst;
	public point[] tmp;
	public point[] ans;
	public point[] ansOneTime;
	public Map(point src,point dst){
		this.src = src;
		this.dst = dst;
		tmp = new point [3];
		tmp[1]=new point(src.x,dst.y);
		tmp[2]=new point(dst.x,src.y);
	}
	
	public point[] getJunctions() {
		PathRequest apr = new PathRequest(src,dst);
		
		String JSON = apr.CulculatePath_Drive();
		if(settings.DEBUG_MODE) {
			System.out.println(JSON);
		}
		PathReturn ret = new PathReturn(JSON);
		
		Route[] rot = ret.getRoutes();
		TreeSet<point>hs = new TreeSet();
		for(int i=1;i<rot.length;i++) {
			point[] p = rot[i].getJunctions();
			for(int j=1;j<p.length;j++)
				hs.add(p[j]);
		}
		ansOneTime = hs.toArray(new point[hs.size()]);
		return ansOneTime;
	}
	public point[] getAllJunction() {

		TreeSet<point> hs = new TreeSet<point>();
		point tmp1 = new point(src.x,dst.y);
		point tmp2 = new point(dst.x,src.y);
		hs.add(tmp1);
		hs.add(tmp2);
		hs.add(src);
		hs.add(dst);
		point [] p1 = Map.getJunctions(src, dst);
		point [] p2 = Map.getJunctions(src, tmp1);
		point [] p3 = Map.getJunctions(src, tmp2);
		point [] p4 = Map.getJunctions(tmp1, dst);
		point [] p5= Map.getJunctions(tmp2, dst);
		point [] p6= Map.getJunctions(tmp1, tmp2);
		point [] u = settings.Link(settings.Link(p1,p2), settings.Link(p3,p4));
		point [] u1 = settings.Link(p5, p6);

		point [] u2 = settings.Link(u, u1);
		for(int i=0;i<u2.length;i++) {
			hs.add(u2[i]);
		}
		for(int i=0;i<p1.length;i++) {
			System.out.print("[Generating Pathes]");
			System.out.print(i);
			System.out.print('\\');
			System.out.println(p1.length);
			point [] Points = Map.getJunctions(p1[i], tmp1);
			point [] Points2 = Map.getJunctions(p1[i], tmp2);
			for(int i1=0;i1<Points.length;i1++) {
				hs.add(Points[i1]);
			}

			for(int i1=0;i1<Points2.length;i1++) {
				hs.add(Points2[i1]);
			}
		}
		for(int i=0;i<p2.length;i++) {
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

		for(int i=0;i<p3.length;i++) {
			System.out.print("[Generating Pathes]");
			System.out.print(i);
			System.out.print('\\');
			System.out.print(p3.length);
			System.out.print("point num :");
			System.out.println(hs.size());
			for(int j=0;j<p4.length;j++) {
				point[] points = Map.getJunctions(p3[i], p4[j]);
				for(int i1=1;i1<points.length;i1++) {
					hs.add(points[i1]);
				}
			}
		}
		System.out.println("[Finnishing]");
		ans = (point[]) hs.toArray(new point[hs.size()]);
		System.out.println(ans.length);
		for(int i=0;i<ans.length;i++) {
			System.out.print("new BMap.Point(");
			System.out.print(ans[i].toString2());
			System.out.println("),");
		}
		return ans;
		
	}
	
	
	
	public static point[] getJunctions(point src,point dst) {
		PathRequest apr = new PathRequest(src,dst);
		
		String JSON = apr.CulculatePath_Drive();
		if(settings.DEBUG_MODE) {
			System.out.println(JSON);
		}
		PathReturn ret = new PathReturn(JSON);
		
		Route[] rot = ret.getRoutes();
		TreeSet<point>hs = new TreeSet();
		for(int i=1;i<rot.length;i++) {
			point[] p = rot[i].getJunctions();
			for(int j=1;j<p.length;j++)
				hs.add(p[j]);
		}
		point[]p = hs.toArray(new point[hs.size()]);
		return p;
	}
	
	public static point[] getAllJunction(point src,point dst) {

		TreeSet<point> hs = new TreeSet<point>();
		point tmp1 = new point(src.x,dst.y);
		point tmp2 = new point(dst.x,src.y);
		hs.add(tmp1);
		hs.add(tmp2);
		hs.add(src);
		hs.add(dst);
		point [] p1 = Map.getJunctions(src, dst);
		point [] p2 = Map.getJunctions(src, tmp1);
		point [] p3 = Map.getJunctions(src, tmp2);
		point [] p4 = Map.getJunctions(tmp1, dst);
		point [] p5= Map.getJunctions(tmp2, dst);
		point [] p6= Map.getJunctions(tmp1, tmp2);
		point [] u = settings.Link(settings.Link(p1,p2), settings.Link(p3,p4));
		point [] u1 = settings.Link(p5, p6);

		point [] u2 = settings.Link(u, u1);
		for(int i=0;i<u2.length;i++) {
			hs.add(u2[i]);
		}
		for(int i=0;i<p1.length;i++) {
			System.out.print("[Generating Pathes]");
			System.out.print(i);
			System.out.print('\\');
			System.out.println(p1.length);
			point [] Points = Map.getJunctions(p1[i], tmp1);
			point [] Points2 = Map.getJunctions(p1[i], tmp2);
			for(int i1=0;i1<Points.length;i1++) {
				hs.add(Points[i1]);
			}

			for(int i1=0;i1<Points2.length;i1++) {
				hs.add(Points2[i1]);
			}
		}
		for(int i=0;i<p2.length;i++) {
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

		for(int i=0;i<p3.length;i++) {
			System.out.print("[Generating Pathes]");
			System.out.print(i);
			System.out.print('\\');
			System.out.print(p3.length);
			System.out.print("point num :");
			System.out.println(hs.size());
			for(int j=0;j<p4.length;j++) {
				point[] points = Map.getJunctions(p3[i], p4[j]);
				for(int i1=1;i1<points.length;i1++) {
					hs.add(points[i1]);
				}
			}
		}
		System.out.println("[Finnishing]");
		point [] ans = (point[]) hs.toArray(new point[hs.size()]);
		System.out.println(ans.length);
		for(int i=0;i<ans.length;i++) {
			System.out.print("new BMap.Point(");
			System.out.print(ans[i].toString2());
			System.out.println("),");
		}
		return ans;
		
	}
	
}
