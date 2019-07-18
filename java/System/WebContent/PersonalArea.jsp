<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language = "java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
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
    </style> 
</head>
<body>
	<%!
		String username="";
		String password="";
		String realname="";
		String unit="";
		String position="";
		String id="";
		String birthdate="";
		String jointime="";
		String tel="";
		String email="";
		String power;
		String subtitle;
		String status;
	%>
	<%
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("username")) {
				username = cookie.getValue();
			}
			if (cookie.getName().equals("status")) {
				status = cookie.getValue();
			}
			if (cookie.getName().equals("power")) {
				power = cookie.getValue();
			}
			else if(!cookie.getName().equals("power")){
				if (cookie.getName().equals("realname")) {
					realname = cookie.getValue();
				}
				if (cookie.getName().equals("unit")) {
					unit = cookie.getValue();
				}
				if (cookie.getName().equals("position")) {
					position = cookie.getValue();
				}
				if (cookie.getName().equals("id")) {
					id = cookie.getValue();
				}
				if (cookie.getName().equals("birthdate")) {
					birthdate = cookie.getValue();
				}
				if (cookie.getName().equals("jointime")) {
					jointime = cookie.getValue();
				}
				if (cookie.getName().equals("tel")) {
					tel = cookie.getValue();
				}
				if (cookie.getName().equals("email")) {
					email = cookie.getValue();
				}
				cookie.setMaxAge(0);
			}
		}
	%>
    <div id="wrapper">
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
                        <li><a href="PersonalAreaServlet?parm=<%=username%>"><i class="fa fa-gear fa-fw"></i>个人设置</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="Login.jsp"><i class="fa fa-sign-out fa-fw"></i>退出登录</a>
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
                        <a href="#"><i class="fa fa-dashboard"></i> 演练事件<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="填写演练事件.html">填写演练事件</a>
                            </li>
                            <li>
                                <a href="查看演练事件.html">查看演练事件</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="演练事件审核.html"><i class="fa fa-desktop"></i> 演练事件审核</a>
                    </li>
					<li>
                        <a href="显示疏散路径.html"><i class="fa fa-bar-chart-o"></i> 显示疏散路径</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-qrcode"></i> 疏散演练<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="人群疏散方案制定.html">人群疏散方案制定</a>
                            </li>
                            <li>
                                <a href="人群疏散方案查看.html">人群疏散方案查看</a>
                            </li>
                        </ul>
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
                        <a href="演练评估.html"><i class="fa fa-edit"></i> 演练评估 </a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-sitemap"></i> 演练事件查询<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="按事件名称查询.html">按事件名称查询</a>
                            </li>
                            <li>
                                <a href="按事件状态查询.html">按事件状态查询</a>
                            </li>
                            <li>
                                <a href="按录入人查询.html">按录入人查询</a>
                            </li>
                            <li>
                                <a href="按演练时间查询.html">按演练时间查询</a>
                            </li>
                        </ul>
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
                                <a class="active-menu" href="PersonalAreaServlet?parm=<%=username%>">个人主页</a>
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
                            个人主页 <small>用户:<%=username%></small>
                        </h1>
                    </div>
                </div>
                <!-- /. 1ROW  -->
               <div class="row">
                <div class="col-md-6">
       			 <form action="PersonalModify.jsp" method="post">
                                  <table border="0" class="becenter">
                                                <tr>
                                                  <th class="tr_block2"></th>
                                                  <th class="tr_name">用户名(警号)</th>
                                                  <th class="tr_block2"></th>
                                                  <th><%=username%></th>
                                                </tr>
                                                <tr>
                                                  <th></th><th>姓名</th>
                                                  <th></th><th><%=realname%></th>
                                                </tr>
                                                <tr>
                                                  <th></th><th>单位</th>
                                                  <th></th><th><%=unit%></th>
                                                </tr>
                                                <tr>
                                                  <th></th><th>职务</th>
                                                  <th></th><th><%=position%></th>
                                                </tr>
                                                <tr>
                                                  <th></th><th>身份证号</th>
                                                  <th></th><th><%=id%></th>
                                                </tr>
                                                <tr>
                                                  <th></th><th>出生年月日</th>
                                                  <th></th><th><%=birthdate%></th>
                                                </tr>
                                                <tr>
                                                  <th></th><th>何时入队</th>
                                                  <th></th><th><%=jointime%></th>
                                                </tr>
                                                <tr>
                                                  <th></th> <th>手机号</th>
                                                  <th></th><th><%=tel%></th>
                                                </tr>
                                                <tr>
                                                  <th></th><th>邮箱</th>
                                                  <th></th><th><%=email%></th>
                                                </tr>
                                                <tr>
                                                  <th></th> <th></th>
                                                  <th></th><th></th>
                                                </tr>
                                                <tr>
                                                  <th></th><th></th>
                                                  <th></th><th><input type="submit" value="修改信息"></th>
                                                </tr>
                                                </table>
                                                <br>
                </form>
            </div>
        		<div class="col-md-6">
        		<img src="imagine/警徽.jpg"  alt="中国人民警察警徽" width="300" height="400"/>
        		</div>
        </div>
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
    <!-- Morris Chart Js -->
    <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="assets/js/morris/morris.js"></script>
    <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>
</body>
</html>