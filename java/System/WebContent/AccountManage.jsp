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
    .tr_block8{
    width:160px;
    }
    .tr_block9{
    width:180px;
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
                        <a href="Querier.jsp"><i class="fa fa-sitemap"></i> 演练事件查询<span class="fa arrow"></span></a>
                        
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-fw fa-file"></i> 系统管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <%
                            	if((Integer.parseInt(power)&4)==4){
                            		subtitle="可修改账户信息";
                            		out.print("<li><a class='active-menu' href='AccountManageServlet'>账户管理</a></li>");
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
        <div id="page-wrapper" >
            <div id="page-inner">
			 <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            账户管理<small><%=subtitle %></small>
                        </h1>
                    </div>
                </div> 
                 <!-- /. ROW  -->
                  <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            账户信息:
                        </div>
                        <div class="panel-body">
                            <div class="panel-group" id="accordion">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                    <table border="1">
                                    <tr>
                                                  <th class="tr_block4">警号</th>
                                                  <th class="tr_block4">姓名</th>
                                                  <th class="tr_block4">密码</th>
                                                  <th class="tr_block9">身份证号</th>
                                                  <th class="tr_block7">手机号码</th>
                                                  <th class="tr_block7">邮箱</th>
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
													for(int j=1;j<7;j++){
														out.print("<th>");
														out.print(ret.get(i)[j]);
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
                                            增加账户
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseOne" class="panel-collapse collapse" style="height: 0px;">
                                        <div class="panel-body">
                                            <form action="AccountInsertServlet" method="post">
				                                  <table border="1">
				                                  <tr>
	 	                                              <th class="tr_block4">警号</th>
	                                                  <th class="tr_block4">密码</th>
	                                                  <th class="tr_block9">身份证号</th>
	                                                  <th class="tr_block7">手机号码</th>
	                                                  <th class="tr_block7">邮箱</th>
				                                   </tr>
				                                   <tr>
					                                   <th><input class="input_4" type="text" name="username"></th>
					                                   <th><input class="input_4" type="text" name="password"></th>
					                                   <th><input class="input_9" type="text" name="id" ></th>
					                                   <th><input class="input_7" type="text" name="tel"></th>
					                                   <th><input class="input_7" type="text" name="email"></th>
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
                                           删除账户
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseTwo" class="panel-collapse collapse" style="height: 0px;">
                                        <div class="panel-body">
                                          请输入需要删除账户的警号:
                                            <form action="AccountDeleteServlet" method="post">
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
                                           修改账户信息
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="collapseThree" class="panel-collapse collapse" style="height: 0px;">
                                        <div class="panel-body">
                                           <form action="AccountModifyServlet" method="post">
				                                  <table border="1">
				                                  <tr>
	 	                                              <th class="tr_block4">警号</th>
	                                                  <th class="tr_block4">密码</th>
	                                                  <th class="tr_block9">身份证号</th>
	                                                  <th class="tr_block7">手机号码</th>
	                                                  <th class="tr_block7">邮箱</th>
				                                   </tr>
				                                   <tr>
					                                   <th><input class="input_4" type="text" name="usernameM"></th>
					                                   <th><input class="input_4" type="text" name="passwordM" ></th>
					                                   <th><input class="input_9" type="text" name="idM" ></th>
					                                   <th><input class="input_7" type="text" name="telM"></th>
					                                   <th><input class="input_7" type="text" name="emailM"></th>
				                                   </tr>
				                                   </table>
				                                   <br>
				                                  <input type="submit" value="修改完成">
				                            </form> 
                                        </div>
                                    </div>
                                </div>
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
