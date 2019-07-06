package org.model.PathDisplay;
import System.Tools.ApiRequest;
import System.Map;
import System.Tools.ApiReturn;
import System.Tools.point;
import System.Tools.result.Route;

import java.util.ArrayList;

import System.Tools.*;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		point src=new point(40.01116,116.339303);
		point dst=new point(39.936404,116.452562);
		point tmp1 = new point(40.01116,116.452562);
		point tmp2 = new point(39.936404,116.339303);
		point [] p1 = Map.getJunctions(src, dst);
		point [] p2 = Map.getJunctions(src, tmp1);
		point [] p3 = Map.getJunctions(src, tmp2);
		point [] p4 = Map.getJunctions(tmp1, dst);
		point [] p5= Map.getJunctions(tmp2, dst);
		point [] p6= Map.getJunctions(tmp1, tmp2);
		
		ArrayList<point[]> arr = new ArrayList<point[]>();
		for(int i=1;i<p1.length;i++) {
			System.out.print("[Generating Pathes]");
			System.out.print(i);
			System.out.print('\\');
			System.out.println(p1.length);
			point [] Points = Map.getJunctions(p1[i], tmp1);
			point [] Points2 = Map.getJunctions(p1[i], tmp2);
			arr.add(Points);
			arr.add(Points2);
		}
		System.out.println("[Finnishing]");
		while(arr.size()!=1) {
			System.out.print("[linking]");
			System.out.print(arr.size());
			System.out.println(" aim : 1");
			point[] t1 = arr.get(0);
			point[] t2 = arr.get(1);
			point [] k= settings.Link(t1, t2);
			arr.remove(0);
			arr.remove(0);
			arr.add(k);
		}
		point [] ans = arr.get(0);
		System.out.println(ans.length);
		for(int i=1;i<ans.length;i++) {
			System.out.print("new BMap.Point(");
			System.out.print(ans[i].toString2());
			System.out.println("),");
		}
//		Map m = new Map(src,dst);
//        String s=HttpRequest.sendGet("http://api.map.baidu.com/reverse_geocoding/v3", "ak=rvgrn6yT8jA11suotGclTuLe9Aj3AivK&output=json&coordtype=wgs84ll&location=31.225696563611,121.49884033194");
//        System.out.println(s);
//        System.out.println();
//        s = settings.getJSON(s);
//        System.out.println(s);
	}

}
