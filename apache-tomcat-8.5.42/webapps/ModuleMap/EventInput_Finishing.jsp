﻿<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

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
    <!-- Google Fonts-->
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
    width:10px;
    }
    .tr_block2{
    width:0%;
    }
    
    .botton1{
    	float:left;
    }
    .botton2{
    	float:right;
    }
    </style>   
</head>

<body>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">人群疏散系统</a>
            </div>
            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-tasks">
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 1</strong>
                                        <span class="pull-right text-muted">60% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (success)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 2</strong>
                                        <span class="pull-right text-muted">28% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="28" aria-valuemin="0" aria-valuemax="100" style="width: 28%">
                                            <span class="sr-only">28% Complete</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 3</strong>
                                        <span class="pull-right text-muted">60% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 4</strong>
                                        <span class="pull-right text-muted">85% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="85" aria-valuemin="0" aria-valuemax="100" style="width: 85%">
                                            <span class="sr-only">85% Complete (danger)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Tasks</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-tasks -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> New Comment
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> Message Sent
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw"></i> New Task
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="#"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
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
                        <a class="active-menu" href="#"><i class="fa fa-dashboard"></i> 演练事件<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="active-menu" href="填写演练事件.html">填写演练事件</a>
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
                            <li>
                                <a href="账户管理.html">账户管理</a>
                            </li>
                            <li>
                                <a href="角色管理.html">角色管理</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
        <!--/. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            填写演练事件
                        </h1>
                    </div> 
                <!-- /. ROW  -->     
                <%!String status = "1"; %>        
                <div class="row">
                    <div class="col-md-6 col-sm-12 col-xs-12">
                         <div class="row">
                            <div class="col-md-2 col-sm-12 col-xs-12">
                            </div>
                            <div class="col-md-10 col-sm-12 col-xs-12">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                        </div>
                                        <form action="EventInputServlet" method="GET">
                                        <div class="panel-body becenter">
                                            <table border="0" class="becenter">
                                                <tr>
                                                  <th class="tr_block2"></th>
                                                  <th class="tr_name">事件名称</th>
                                                  <th class="tr_block"></th>
                                                  <th class="tr_input"><input type="text" class="form-control" name="EventName" value=""></th>
                                                </tr>
                                                <tr>
                                                  <th></th>
                                                  <th>事件类型</th>
                                                  <th></th>
                                                  <th>
                                                  		<select class="form-control" name = "EventType">
													        <option>恐怖袭击</option>
													        <option>火灾</option>
													        <option>自然灾害</option>
												        </select> 
											      </th>
                                                </tr>
                                                <tr>
                                                  <th></th>
                                                  <th>输入模式</th>
                                                  <th></th>
                                                  <th>
                                                  		<select class="form-control" name = "Mode">
													        <option>地址模式</option>
													        <option>坐标模式</option>
												        </select> 
											      </th>
                                                </tr>
                                                <tr>
                                                  <th></th>
                                                  <th>疏散点</th>
                                                  <th></th>
                                                  <th><input type="text" class="form-control"name="origin" value="" title="地址（'xx市xx街道xx号'）或坐标（'40.321231,139.098765'）不含引号。经纬度最多支持小数点后六位"></th>
                                                </tr>
                                                <tr>
                                                  <th></th>
                                                  <th>避难点</th>
                                                  <th></th>
                                                  <th><input type="text" class="form-control" name="destination" value=""title="地址（'xx市xx街道xx号'）或坐标（'40.321231,139.098765'）不含引号。经纬度最多支持小数点后六位"></th>
                                                </tr>
                                                <tr>
                                                  <th></th>
                                                  <th>待疏散人群</th>
                                                  <th></th>
                                                  <th><input type="text" class="form-control" name="Crowd" value=""></th>
                                                </tr>
                                                <tr>
                                                  <th></th>
                                                  <th>录入人编号</th>
                                                  <th></th>
                                                  <th><input type="text" class="form-control" name="policeId" value=""></th>
                                                </tr>
                                                <tr>
                                                  <th></th>
                                                  <th>演练时间</th>
                                                  <th></th>
                                                  <th><input type="text" class="form-control" name="Time" value=""></th>
                                                </tr>
                                                <tr>
                                                  <th></th>
                                                  <th><input type="button" class="btn btn-default botton1"value="清除内容" onclick="javascrtpt:window.location.href='填写演练事件.jsp'"></th>
                                                  <th></th>
                                                  <th><input type="submit"class="btn btn-default botton2"  value="填写完成" ></th>
                                                </tr>
                                                <input type="text" hidden="hidden"  name = "status" value="<%=status%>" >
                                                </table>        
                                             	<%
                                                	String message=null;
                                                	HttpSession sess = request.getSession();
                                                	message = (String)sess.getAttribute("message");
                                                	status = (String)sess.getAttribute("status");
                                                	if(message!=null)
                                                		out.print(message);
                                                %>
                                        </div>
                                        </form>
                                    </div>
                                </div>         
                    </div>            
                </div>
                </div>
                <!-- /. 1ROW  -->
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
     <!-- Morris Chart Js -->
     <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="assets/js/morris/morris.js"></script>
      <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>
    
   
</body>
</html>