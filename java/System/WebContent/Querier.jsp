<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>人群疏散系统</title>
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
<link href="assets/css/custom-styles.css" rel="stylesheet" />
<link href='assets/fonts/OpenSans-Regular.ttf' rel='stylesheet'
	type='text/css' />
<link href='assets/css/SchemeMake/custom.css' rel='stylesheet'
	type='text/css' />
<%@ page contentType="text/html;charset=utf-8"%>
</head>
<style>
.botton1 {
	float: left;
}

.botton2 {
	float: right;
}

<%@page import="org.model.SchemeMake.PathApi.PathRequest"%>
<%@page import="org.model.BaiduMap"%>
<%@page import="org.model.settings"%>
<%@page import="org.model.SchemeMake.PathApi.PathReturn"%>
<%@page import="org.model.SchemeMake.Units.vertex"%>
<%@page import="org.model.SchemeMake.Units.edge"%>
<%@page import="org.model.SchemeMake.Units.capacity"%>
<%@page import="org.model.SchemeMake.PathApi.result.Route"%>
<%@page import="org.model.Query"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Iterator"%>
</style>
<body>
	<div id="wrapper">
		    <%
	String username = null;
	Cookie[] cookies = request.getCookies();
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("username")) {
			username = cookie.getValue();
		}
	}
	if(username==null){
		out.println("<script>alert('没有权限 ')</script>");
		return;
	}
	%>
		<%!
			String power;
			String status;
			String subtitle;
		%>
		<%
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("power")) {
					power = cookie.getValue();
				}
				if (cookie.getName().equals("status")) {
					status = cookie.getValue();
				}
			}
		%>
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">人群疏散系统</a>
            </div>
            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i>用户名:<%=username %></a>
                        </li>
                        <li><a href="PersonalAreaServlet"><i class="fa fa-gear fa-fw"></i>个人设置</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="Login.jsp?quit=1"><i class="fa fa-sign-out fa-fw"></i>退出登录</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
        </nav>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <a href="audit.jsp"><i class="fa fa-desktop"></i> 演练事件审核</a>
                    </li>
					<li>
                        <a href="displayer.jsp?Project_id=1"><i class="fa fa-bar-chart-o"></i> 显示疏散路径</a>
                    </li>
                    <li>
                        <a href="SchemeMake.jsp"><i class="fa fa-qrcode"></i> 人群疏散方案制定</a>
                    </li>
                    
                    <li>
                        <a href="#"><i class="fa fa-table"></i> 保护演练<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="人群保护方案制定.html">人群保护方案制定</a>
                            </li>
                            <li>
                                <a href="人群保护方案查看.html">人群保护方案查看</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="Evaluator.jsp"><i class="fa fa-edit"></i> 演练评估 </a>
                    </li>
                    <li>
                        <a class="active-menu" href="Querier.jsp"><i class="fa fa-sitemap"></i> 演练事件查询 </a>
                        
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-fw fa-file"></i> 系统管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <%
                            	if((Integer.parseInt(power)&4)==4){
                            		subtitle="可修改账户信息";
                            		out.print("<li><a href='AccountManageServlet'>账户管理</a></li>");
                            	}
                            %>
                            <%
                            	if((Integer.parseInt(power)&2)==2 && status.equals("1")){
                            		subtitle="可修改角色信息";
                            		out.print("<li><a href='RoleManageServlet'>角色管理</a></li>");
                            	}
                            %>
                            <li>
                                <a href="PersonalAreaServlet">个人主页</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-header">
							演练事件查询<small>Querier</small>
						</h1>
					</div>
				</div>

				<%
				String EventID = null;
				String EventName = null;
				String UserID = null;
				String DrillTime = null;
				String pageNum = null;
				String URL = "Querier.jsp?";
				int pages=1;
				int CurrPage=1;
				int nums=1;
				EventID=request.getParameter("EventID");
				EventName=request.getParameter("EventName");
				UserID=request.getParameter("UserID");
				DrillTime=request.getParameter("DrillTime");
				pageNum=request.getParameter("pageNum");
				String sql = "select * from e_event ";
				String sqlnum = "select count(*) from e_event ";
				if(EventID!=null&&!EventID.equals("")&&!EventID.equals("null")){
					sql+="where event_id='"+EventID+"'";
					sqlnum+="where event_id='"+EventID+"'";
					URL+="EventID="+EventID;
				}
				if(EventName!=null&&!EventName.equals("")&&!EventName.equals("null")){
					sql+="where e_name='"+EventName+"'";
					sqlnum+="where e_name='"+EventName+"'";
					URL+="EventName="+EventName;
				}
				if(UserID!=null&&!UserID.equals("")&&!UserID.equals("null")){
					sql+="where recorder='"+UserID+"'";
					sqlnum+="where recorder='"+UserID+"'";
					URL+="UserID="+UserID;
				}
				if(DrillTime!=null&&!DrillTime.equals("")&&!DrillTime.equals("null")){
					sql+="where DrillTime='"+DrillTime+"'";
					sqlnum+="where DrillTime='"+DrillTime+"'";
					URL+="DrillTime="+DrillTime;
				}
				System.out.println(pageNum);
				if(pageNum!=null&&!pageNum.equals("")&&!pageNum.equals("null")){
					CurrPage=Integer.parseInt(pageNum);
					sql += " limit "+Integer.toString((CurrPage-1)*10)+", 10";
				}
				else{
					sql += " limit 0, 10";
				}
				System.out.println(sql);
				System.out.println(URL);
				ArrayList<String[]>ret = Query.runSql(9,sql);
				ArrayList<String[]>num = Query.runSql(1,sqlnum);
				
				if(ret!=null&&ret.size()!=0)
					nums=Integer.parseInt(num.get(0)[1]);
				else{
					nums=1;
				}
				pages=nums/10+1;
				String id1=null;
				String id2=null;
				for(int i=0;i<ret.size();i++){
					id1 = ret.get(i)[4];
					id2 = ret.get(i)[5];
					String sql1 = "select x_coordinate,y_coordinate from point where p_id='"+id1+"'";
					String sql2 = "select x_coordinate,y_coordinate from point where p_id='"+id2+"'";

					ArrayList<String[]>ret1 = Query.runSql(2,sql1);
					ArrayList<String[]>ret2 = Query.runSql(2,sql2);
					if(ret1==null||ret2==null||ret1.size()==0||ret2.size()==0){
			        	out.print("<script>alert('未知记录'); window.location='Querier.jsp'</script>");
			        	out.flush();
			        	return;
					}
					ret.get(i)[4]=ret1.get(0)[1]+","+ret1.get(0)[2];
					ret.get(i)[5]=ret2.get(0)[1]+","+ret1.get(0)[2];
				}
				%>
				<div class="col-md-12">
					<!-- Advanced Tables -->
					<div class="panel panel-default">
						<div class="panel-heading">记录</div>
						<div class="panel-body">
							<div class="table-responsive">
								<div id="dataTables-example_wrapper"
									class="dataTables_wrapper form-inline" role="grid">
									<div class="row">
										<div class="col-sm-12">
											<form action="Querier.jsp" method="GET">
												<div id="dataTables-example_filter"
													class="dataTables_filter">
													<label>事件ID:<input autocomplete="off" type="text"
														class="form-control input-sm"
														aria-controls="dataTables-example" name="EventID"></label>
													<label>事件名称:<input autocomplete="off" type="text"
														class="form-control input-sm"
														aria-controls="dataTables-example" name="EventName"></label>
													<label>录入者警号:<input autocomplete="off" type="text"
														class="form-control input-sm"
														aria-controls="dataTables-example" name="UserID"></label>
													<label>演练时间:<input autocomplete="off" type="date"
														class="form-control input-sm"
														aria-controls="dataTables-example" name="DrillTime"></label>
													<label><input autocomplete="off" type="submit"
														class="form-control input-sm"
														aria-controls="dataTables-example" value="搜索"
														></label>
												</div>
											</form>
										</div>
									</div>
									<div style="height:10px;"></div>
									<table
										class="table table-striped table-bordered table-hover dataTable no-footer"
										id="dataTables-example"
										aria-describedby="dataTables-example_info">
										<thead>
											<tr role="row">
												<th class="sorting_asc" tabindex="0"
													aria-controls="dataTables-example" rowspan="1" colspan="1"
													aria-sort="ascending"
													aria-label="Rendering engine: activate to sort column ascending"
													style="width: 200px;">事件ID</th>
												<th class="sorting" tabindex="0"
													aria-controls="dataTables-example" rowspan="1" colspan="1"
													aria-label="Browser: activate to sort column ascending"
													style="width: 295px;">事件名称</th>
												<th class="sorting" tabindex="0"
													aria-controls="dataTables-example" rowspan="1" colspan="1"
													aria-label="Browser: activate to sort column ascending"
													style="width: 295px;">事件类型</th>
												<th class="sorting" tabindex="0"
													aria-controls="dataTables-example" rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													style="width: 275px;">疏散点</th>
												<th class="sorting" tabindex="0"
													aria-controls="dataTables-example" rowspan="1" colspan="1"
													aria-label="Engine version: activate to sort column ascending"
													style="width: 168px;">避难点</th>
												<th class="sorting" tabindex="0"
													aria-controls="dataTables-example" rowspan="1" colspan="1"
													aria-label="CSS grade: activate to sort column ascending"
													style="width: 119px;">录入人</th> 
												<th class="sorting" tabindex="0"
													aria-controls="dataTables-example" rowspan="1" colspan="1"
													aria-label="CSS grade: activate to sort column ascending"
													style="width: 119px;">演练时间</th>
											</tr>
										</thead>
										<tbody>
											<%
											for(int i=0;i<ret.size();i++){
												String[] line = ret.get(i);
												out.println("<tr class=\"gradeA odd\">");
												out.println("<td class=\"sorting_1\">"+line[1]+"</td>");
												out.println("<td class=\" \">"+line[2]+"</td>");
												out.println("<td class=\" \">"+line[3]+"</td>");
												out.println("<td class=\"center \">"+line[4]+"</td>");
												out.println("<td class=\"center \">"+line[5]+"</td>");
												out.println("<td class=\"center \">"+line[8]+"</td>");
												out.println("<td class=\"center \">"+line[9]+"</td>");
											}
											
											%>
										</tbody>
									</table>
									<div class="row">
										<div class="col-sm-6">
											<div class="dataTables_info" id="dataTables-example_info"
											<%
											int curr=0;
											if(nums>0){
												curr=(pages-1)*10+1;
											}
											int M = 0;
											if(nums>10){
												M=10;
											}
											else M = nums;
											%>
												role="alert" aria-live="polite" aria-relevant="all">Showing
												<%=curr %> to <%=M %> of <%=nums %> entries</div>
										</div>
										<div class="col-sm-6">
											<div class="dataTables_paginate paging_simple_numbers"
												id="dataTables-example_paginate">
												<ul class="pagination">
												<%

												if(CurrPage==1){
													out.println("<li class=\"paginate_button previous disabled\"");
													out.println("aria-controls=\"dataTables-example\" tabindex=\"0\"");
													out.println("id=\"dataTables-example_previous\"><a href=\"#\">Previous</a></li>");
												}
												else{
													out.println("<li class=\"paginate_button previous\"");
													out.println("aria-controls=\"dataTables-example\" tabindex=\"0\"");
													out.println("id=\"dataTables-example_previous\"><a href=\""+URL+"&PageNum="+Integer.toString(CurrPage-1)+"\">Previous</a></li>");
													
												}
												
												for(int i=1;i<=pages;i++){
													if(i==CurrPage){
														out.println("<li class=\"paginate_button active\"");
														out.println("aria-controls=\"dataTables-example\" tabindex=\""+Integer.toString(i)+"\"><a");
													}
													else{
														out.println("<li class=\"paginate_button\"");
														out.println("aria-controls=\"dataTables-example\" tabindex=\""+Integer.toString(i)+"\"><a");
													}
													out.println("href=\""+URL+"&pageNum="+Integer.toString(i)+"\">"+Integer.toString(i)+"</a></li>");
												}%><% 
													
													if(CurrPage==pages){
														out.println("<li class=\"paginate_button next disabled\"");
													}
													else{
														out.println("<li class=\"paginate_button next\"");
													}
														out.println("aria-controls=\"dataTables-example\" tabindex=\"0\"");
														out.println("id=\"dataTables-example_next\"><a href=\""+URL+"&pageNum="+Integer.toString(CurrPage+1)+"\">Next</a></li>");
														
													%>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
					<!--End Advanced Tables -->
				</div>

				<footer>
					<p>
						Copyright &copy; 2016.Company name All rights reserved.<a
							target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
					</p>
				</footer>
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- /. WRAPPER  -->
	<!-- JS Scripts-->
	<!-- jQuery Js -->
	<script src="assets/js/jquery-3.1.0.js"></script>
	<!-- Bootstrap Js -->
	<script src="assets/js/bootstrap.min.js"></script>
	<!-- Metis Menu Js -->
	<script src="assets/js/jquery.metisMenu.js"></script>
	<!-- Custom Js -->
	<script src="assets/js/custom-scripts.js"></script>
	<script src="assets/js/morris/morris.js"></script>
	<script src="assets/js/SchemeMake/costom.js"></script>


</body>
</html>
