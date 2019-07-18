<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/ TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language = "java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" import="java.util.ArrayList"%>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>人群疏散系统</title>
    <!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <style> 
    .becenter{text-align:center} 
    </style> 
        <%!
    public static String toBinary(int num, int digits) {
		    String cover = Integer.toBinaryString(1 << digits).substring(1);
		    String s = Integer.toBinaryString(num);
		    return s.length() < digits ? cover.substring(s.length()) + s : s;
		}
	%>
    <style> 

    th{
    height:40px;
    text-align:justify;
    text-align-last:justify;
    } 
    .tr_name{
     width:100px;
    }
    .tr_input{
      width:300px;
    }
    .tr_block{
    width:20px;
    }
    .tr_block2{
    width:40px;
    }
    .tr_block3{
    width:60px;
    }
    .tr_block4{
    width:80px;
    }
    .tr_block5{
    width:100px;
    }
    .tr_block6{
    width:120px;
    }
    .tr_block7{
    width:140px;
    }
    .input_1{
    	width:20px;
    }
    .input_2{
    	width:40px;
    }
    .input_3{
    	width:60px;
    }
    .input_4{
    	width:80px;
    }
    .input_5{
    	width:100px;
    }
    .input_6{
    	width:120px;
    }
    .input_7{
    	width:140px;
    }
    .input_8{
    	width:160px;
    }
    .input_9{
    	width:180px;
    }
    </style> 
</head>
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
                                <a href="#">人群保护方案制定</a>
                            </li>
                            <li>
                                <a href="#">人群保护方案查看</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="Evaluator.jsp"><i class="fa fa-edit"></i> 演练评估 </a>
                    </li>
                    <li>
                        <a href="Querier.jsp"><i class="fa fa-sitemap"></i> 演练事件查询 </a>
                        
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
                            		out.print("<li><a class='active-menu' href='RoleManageServlet'>角色管理</a></li>");
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
        <div id="page-wrapper" >
            <div id="page-inner">
			 <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            角色管理<small><%=subtitle%></small>
                        </h1>
                    </div>
                </div> 
                 <!-- /. ROW  -->
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            角色信息:
                        </div>
                        <div class="panel-body">
                            <div class="panel-group" id="accordion">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                    <table border="1">
                                    <tr>
                                                  <th class="tr_block4">警号</th>
                                                  <th class="tr_block4">姓名</th>
                                                  <th class="tr_block6">单位</th>
                                                  <th class="tr_block4">职务</th>
                                                  <th class="tr_block6">出生日期</th>
                                                  <th class="tr_block6">入队日期</th>
                                                  <th class="tr_block4">角色名称</th>
                                                  <th class="tr_block4">角色状态</th>
                                                  <%
	                                                  if((Integer.parseInt(power)&8)==8){
	  													out.print("<th class='tr_block4'>");
	  													out.print("权限码");
	  													out.print("</th>");
	  												  }
                                                  %>
                                   </tr>
                                     <%
	                                    request.setCharacterEncoding("utf-8");
	                                    response.setContentType("text/html;charset=utf-8");	
										HttpSession sess = request.getSession();
	                                    ArrayList<String[]> ret = new ArrayList<String[]>();
										ret = (ArrayList<String[]>)sess.getAttribute("ret");
										if (ret.size()!=0) {
											for(int i=0;i<ret.size();i++)
											{
												out.print("<tr>");
												for(int j=1;j<9;j++){
													out.print("<th>");
													out.print(ret.get(i)[j]);
													out.print("</th>");
												}
												if((Integer.parseInt(power)&8)==8){
													String k = toBinary(Integer.parseInt(ret.get(i)[9]),11);
													out.print("<th>");
													out.print(k);
													out.print("</th>");
												}
												out.print("</tr>");
											}
										}
										session.invalidate();
									%>
									</table>
                                	</div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" class="collapsed">
                                            增加角色
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseOne" class="panel-collapse collapse" style="height: 0px;">
                                        <div class="panel-body">
                                            <form action="RoleInsertServlet" method="post">
				                                  <table border="1">
				                                  <tr>
	 	                                              <th class="tr_block4">警号</th>
				                                      <th class="tr_block4">姓名</th>
				                                      <th class="tr_block6">单位</th>
				                                      <th class="tr_block4">职务</th>
			                                          <th class="tr_block6">出生日期</th>
				                                      <th class="tr_block6">入队日期</th>
				                                      <th class="tr_block4">角色名称</th>
				                                      <th class="tr_block7">角色状态</th>
				                                   </tr>
				                                   <tr>
					                                   <th><input class="input_4" type="text" name="username" id="use"></th>
					                                   <th><input class="input_4" type="text" name="realname" ></th>
					                                   <th><input class="input_6"type="text" name="unit" ></th>
					                                   <th><input class="input_4" type="text" name="position" ></th>
					                                   <th><input class="input_6"type="text" name="birthdate" id="bir" ></th>
					                                   <th><input class="input_6" type="text" name="jointime"></th>
					                                   <th><input class="input_4" type="text" name="role_name"></th>
					                                   <th>
					                                   <label><input type="radio" name="status" value="1">启用</label>
													   <label><input type="radio" name="status" value="0">不启用</label>
													   </th>
				                                   </tr>
				                                   </table>
				                                   <br>
				                                  <input type="submit" value="增加完成">
				                            </form>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" class="collapsed">
                                            删除角色
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseTwo" class="panel-collapse collapse" style="height: 0px;">
                                        <div class="panel-body">
                                          请输入需要删除角色的警号:
                                            <form action="RoleDeleteServlet" method="post">
                                            	<input class="input_4 becenter" type="text" name="usernameD">
                                            	<input type="submit" value="确认删除">
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" class="collapsed">
                                            修改角色信息
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseThree" class="panel-collapse collapse" style="height: 0px;">
                                        <div class="panel-body">
                                           <form action="RoleModifyServlet" method="post">
				                                  <table border="1">
				                                  <tr>
	 	                                              <th class="tr_block4">警号</th>
				                                      <th class="tr_block4">姓名</th>
				                                      <th class="tr_block6">单位</th>
				                                      <th class="tr_block4">职务</th>
			                                          <th class="tr_block6">出生日期</th>
				                                      <th class="tr_block6">入队日期</th>
				                                      <th class="tr_block4">角色名称</th>
				                                   </tr>
				                                   <tr>
					                                   <th><input class="input_4" type="text" name="usernameM"></th>
					                                   <th><input class="input_4" type="text" name="realnameM" ></th>
					                                   <th><input class="input_6" type="text" name="unitM" ></th>
					                                   <th><input class="input_4" type="text" name="positionM" ></th>
					                                   <th><input class="input_6" type="text" name="birthdateM"></th>
					                                   <th><input class="input_6" type="text" name="jointimeM"></th>
					                                   <th><input class="input_4" type="text" name="role_nameM"></th>
				                                   </tr>
				                                   </table>
				                                   <br>
				                                  <input type="submit" value="修改完成">
				                            </form> 
                                        </div>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour" class="collapsed">
                                            启用/停用角色
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseFour" class="panel-collapse collapse" style="height: 0px;">
                                        <div class="panel-body">
                                            <form action="RoleEnableServlet" method="post">
				                                  <table border="1">
				                                  <tr>
	 	                                              <th class="tr_block4">警号</th>
				                                      <th class="tr_block7">角色状态</th>
				                                   </tr>
				                                   <tr>
					                                   <th><input class="input_4" type="text" name="usernameC"></th>
					                                   <th>
					                                   <label><input type="radio" name="statusC" value="1">启用</label>
													   <label><input type="radio" name="statusC" value="0">停用</label>
													   </th>
				                                   </tr>
				                                   </table>
				                                   <br>
				                                  <input type="submit" value="操作完成">
				                            </form>
                                        </div>
                                    </div>
                                </div>
                                <%
	                                if((Integer.parseInt(power)&8)==8){
	                            		out.print("<div class='panel panel-default'><div class='panel-heading'><h4 class='panel-title'>"
                                        +"<a data-toggle='collapse' data-parent='#accordion' href='#collapseFive' class='collapsed'>修改角色权限</a></h4></div>"
                                    	+"<div id='collapseFive' class='panel-collapse collapse' style='height: 0px;'>"
                                        +"<div class='panel-body'>"
                                        +"<form action='RolePowerServlet' method='post'>"
				                        +"<table border='1'>"
				                        +"<tr><th class='tr_block4'>警号</th><th class='tr_block9'>角色权限（添加权限打√去除不打√）</th></tr>"
				                        +"<tr><th><input class='input_4' type='text' name='usernameX'></th><th>"
					                    +"   <label><input type='checkbox' name='power1' value='2'>可修改角色信息</label>"
										+"	 <label><input type='checkbox' name='power2' value='4'>可修改账户信息</label>"
										+"	 <label><input type='checkbox' name='power3' value='8'>可修改角色权限</label>"
										+"	 <label><input type='checkbox' name='power4' value='32'>可修改方案信息</label>"
										+"</th></tr></table><br><input type='submit' value='操作完成'></form></div></div></div>");
	                            	}
                                %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                    <!-- /. ROW  -->
				 <footer><p>Copyright &copy; 2016.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p></footer>
				</div>
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
        </div>
     <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="assets/js/jquery.metisMenu.js"></script>
      <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>
    
   
</body>
</html>
