/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.42
 * Generated at: 2019-07-11 08:32:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {


		String set="";
	
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("    <title>人群疏散系统</title>\r\n");
      out.write("    <!-- Bootstrap Styles-->\r\n");
      out.write("    <link href=\"assets/css/bootstrap.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <!-- FontAwesome Styles-->\r\n");
      out.write("    <link href=\"assets/css/font-awesome.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <!-- Morris Chart Styles-->\r\n");
      out.write("    <link href=\"assets/js/morris/morris-0.4.3.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <!-- Custom Styles-->\r\n");
      out.write("    <link href=\"assets/css/custom-styles.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <style> \r\n");
      out.write("    .becenter{text-align:center} \r\n");
      out.write("    </style> \r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      out.write('\r');
      out.write('\n');
      out.write('	');

		Cookie[] cookies = request.getCookies();
	if(cookies!=null)
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("message")) {
				set = cookie.getValue();
			}
		}
	
      out.write("\r\n");
      out.write("    <div id=\"wrapper\">\r\n");
      out.write("        <nav class=\"navbar navbar-default top-navbar\" role=\"navigation\">\r\n");
      out.write("            <div class=\"navbar\">\r\n");
      out.write("                <p class=\"navbar-brand\">人群疏散系统</p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("        <!--/. NAV TOP  -->\r\n");
      out.write("            <div id=\"page-inner\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-12\">\r\n");
      out.write("                        <h1 class=\"page-header\">\r\n");
      out.write("                        </h1>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /. ROW  -->\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-4 col-sm-12 col-xs-12\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-4 col-sm-12 col-xs-12\">\r\n");
      out.write("                        <div class=\"panel panel-default\">\r\n");
      out.write("                            <div class=\"panel-heading important\">\r\n");
      out.write("                                登录界面\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"panel-body\" >\r\n");
      out.write("                                <div class= \"row\">\r\n");
      out.write("                                    <div class=\"col-md-2 col-sm-12 col-xs-12\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-md-10 col-sm-12 col-xs-12\">\r\n");
      out.write("                                    <form action=\"LoginServlet\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t 用户名:<br>\r\n");
      out.write("\t                                    <input type=\"text\" name=\"username\" placeholder=\"Username\">\r\n");
      out.write("\t                                    <br>\r\n");
      out.write("\t                             \t       密码:<br>\r\n");
      out.write("\t                                    <input type=\"password\" name=\"password\" placeholder=\"Password\">\r\n");
      out.write("\t                                    <br><br>\r\n");
      out.write("\t                                    <input type=\"button\" value=\"注册用户\" onclick=\"javascrtpt:window.location.href='Register.jsp'\">\r\n");
      out.write("\t                                    <input type=\"button\" value=\"忘记密码\" onclick=\"javascrtpt:window.location.href='Forget.jsp'\">\r\n");
      out.write("\t                                    <input type=\"button\" value=\"修改密码\" onclick=\"javascrtpt:window.location.href='Modify.jsp'\">\r\n");
      out.write("\t                                    <input type=\"submit\" value=\"登录\" >\r\n");
      out.write("\t                                </form>\r\n");
      out.write("\t                                ");
      out.print(set);
      out.write("\r\n");
      out.write("\t                                ");

		                                set=" ";
	                                
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");

										HttpSession sess = request.getSession();
										String message ="";
										message=(String)sess.getAttribute("message");
								        if(message == "用户名或密码有误!"){
											out.print(message);
										}
								        session.invalidate();
									 
      out.write("\r\n");
      out.write("                                    </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <footer><p class=\"becenter\">Copyright &copy; 2016.Company name All rights reserved.<a target=\"_blank\" href=\"http://sc.chinaz.com/moban/\">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p></footer>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>    \r\n");
      out.write("            <!-- /. PAGE INNER  -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- /. PAGE WRAPPER  -->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /. WRAPPER  -->\r\n");
      out.write("    <!-- JS Scripts-->\r\n");
      out.write("    <!-- jQuery Js -->\r\n");
      out.write("    <script src=\"assets/js/jquery-1.10.2.js\"></script>\r\n");
      out.write("    <!-- Bootstrap Js -->\r\n");
      out.write("    <script src=\"assets/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <!-- Metis Menu Js -->\r\n");
      out.write("    <script src=\"assets/js/jquery.metisMenu.js\"></script>\r\n");
      out.write("    <!-- Morris Chart Js -->\r\n");
      out.write("    <script src=\"assets/js/morris/raphael-2.1.0.min.js\"></script>\r\n");
      out.write("    <script src=\"assets/js/morris/morris.js\"></script>\r\n");
      out.write("    <!-- Custom Js -->\r\n");
      out.write("    <script src=\"assets/js/custom-scripts.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
