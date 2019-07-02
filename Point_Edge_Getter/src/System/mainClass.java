package System;

import System.Tools.settings;

public class mainClass {
	
	public static void main(String[] args) {
		point src=new point(0.0,0.0);
		point dst=new point(0.0,0.0);
		//扩大搜索范围，比如将西北点进行下取整数，对东南点上取整
		//添加代码
		//**************************************************//
		Map m = new Map(src,dst);
        String s=HttpRequest.sendGet("http://api.map.baidu.com/reverse_geocoding/v3", "ak=rvgrn6yT8jA11suotGclTuLe9Aj3AivK&output=json&coordtype=wgs84ll&location=31.225696563611,121.49884033194");
        System.out.println(s);
        System.out.println();
        s = settings.getJSON(s);
        System.out.println(s);
        
	}
}
