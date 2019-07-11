<!DOCTYPE html>
<html>
<head>
<meta >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
	body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=rvgrn6yT8jA11suotGclTuLe9Aj3AivK"></script>
	<title>地图展示</title>
</head>
<body>
	<div id="allmap"></div>
</body>

<script type="text/javascript">

</script>
<%@page import="org.model.SchemeMake.Tools.ApiRequest"%>
<%@page import="org.model.Map"%>
<%@page import="org.model.SchemeMake.Tools.settings"%>
<%@page import="org.model.SchemeMake.Tools.ApiReturn"%>
<%@page import="org.model.SchemeMake.Tools.point"%>
<%@page import="org.model.SchemeMake.Tools.result.Route"%>
<%@page import="java.util.ArrayList"%>

<script type="text/javascript">
	// 百度地图API功能
	var points=[
		<%
		
		float x1 = (float)39.084105;
		float y1 = (float)121.817608;
		float x2 = (float)39.057184;
		float y2 = (float)121.781387;
		
		point src=new point(x1,y1);
		point dst=new point(x2,y2);
		point [] ans = Map.getAllJunction(src,dst);
		for (point p : ans){
			out.print("new BMap.Point(");
			out.print(p.toString2());
			out.println("),");
		}
		
		%>
	];
	var map = new BMap.Map("allmap");    // 创建Map实例
	map.centerAndZoom(new BMap.Point(121.817608, 39.084105), 11);  // 初始化地图,设置中心点坐标和地图级别
	//添加地图类型控件
	map.addControl(new BMap.MapTypeControl({
		mapTypes:[
            BMAP_NORMAL_MAP,
            BMAP_HYBRID_MAP
        ]}));	  
	map.setCurrentCity("大连");          // 设置地图显示的城市 此项是必须设置的
	map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
    var plPoints = [{weight:2,color:"blue",opacity:0.6,points:["121.820719,39.087036","122.25734,29.735576","122.26043,29.731436","122.256262,29.728614","122.257418,29.7253407","122.257783,29.722075","122.2649623,29.720381"]}
    ];
    //向地图中添加线函数
    function addPolyline(){
        for(var i=0;i<plPoints.length;i++){
            var json = plPoints[i];
            var points = [];
            for(var j=0;j<json.points.length;j++){
                var p1 = json.points[j].split(",")[0];
                var p2 = json.points[j].split(",")[1];
                points.push(new BMap.Point(p1,p2));
            }
            var line = new BMap.Polyline(points,{strokeWeight:json.weight,strokeColor:json.color,strokeOpacity:json.opacity});
            map.addOverlay(line);
 
        }
    }
    points.forEach(function(value) {  
    	var locMarkers;
    	locMarkers = new BMap.Marker(value);
     
    	map.addOverlay(locMarkers);		//将标注添加到地图中
    	
    	locMarkers.disableMassClear();	//设置marker不可被清除
    	
    	;  
    });

    addPolyline();
</script>

</html>
