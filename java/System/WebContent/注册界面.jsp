<!DOCTYPE html>
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
    width:25%;
    }
    </style>   
</head>

<body>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar">
                <p class="navbar-brand">人群疏散系统</p>
            </div>
        </nav>
        <!--/. NAV TOP  -->
        <div id="login">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                        </h1>
                    </div>
                </div>
                <!-- /. ROW  -->
                <div class="row">
                    <div class="col-md-4 col-sm-12 col-xs-12">
                    </div>
                    <div class="col-md-4 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading important">
                                	注册用户
                            </div>
                            <div class="panel-body  becenter" >
                            <form action="RegisterServlet" method="post">
                                  <table border="1" class="becenter">
                                                <tr>
                                                  <th class="tr_block2"></th>
                                                  <th class="tr_name">用户名(警号)</th>
                                                  <th class="tr_block"></th>
                                                  <th class="tr_input"><input type="text" name="username" ></th>
                                                </tr>
                                                <tr>
                                                  <th></th>
                                                  <th>密码</th>
                                                  <th></th>
                                                  <th><input type="password" name="password" ></th>
                                                </tr>
                                                <tr>
                                                  <th></th>
                                                  <th>姓名</th>
                                                  <th></th>
                                                  <th><input type="text" name="realname" ></th>
                                                </tr>
                                                <tr>
                                                  <th></th>
                                                  <th>单位</th>
                                                  <th></th>
                                                  <th><input type="text" name="unit" ></th>
                                                </tr>
                                                <tr>
                                                  <th></th>
                                                  <th>职务</th>
                                                  <th></th>
                                                  <th><input type="text" name="position" ></th>
                                                </tr>
                                                <tr>
                                                  <th></th>
                                                  <th>身份证号</th>
                                                  <th></th>
                                                  <th><input type="text" name="id" ></th>
                                                </tr>
                                                <tr>
                                                  <th></th>
                                                  <th>出生年月日</th>
                                                  <th></th>
                                                  <th><input type="text" name="birthdate" ></th>
                                                </tr>
                                                <tr>
                                                  <th></th>
                                                  <th>何时入队</th>
                                                  <th></th>
                                                  <th><input type="text" name="jointime" ></th>
                                                </tr>
                                                <tr>
                                                  <th></th>
                                                  <th>手机号</th>
                                                  <th></th>
                                                  <th><input type="text" name="tel" ></th>
                                                </tr>
                                                <tr>
                                                  <th></th>
                                                  <th>邮箱</th>
                                                  <th></th>
                                                  <th><input type="text" name="email" ></th>
                                                </tr>
                                                </table>
                                                <br>
                                  <input type="submit" value="注册完成">
                            </form>
                            <%
								HttpSession sess = request.getSession();
								String verify = null;
								verify=(String)sess.getAttribute("verify");
								if(verify!=null){
									out.print(verify);
								}
								session.invalidate(); 
							 %>
                            </div>
                            <footer><p class="becenter">Copyright &copy; 2016.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p></footer>
                        </div>
                    </div>
                </div>
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