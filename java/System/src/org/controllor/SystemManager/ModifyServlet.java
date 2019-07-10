package org.controllor.SystemManager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.model.SystemManage.ModifyDao;
import org.model.SystemManage.User;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        String modify=null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        User user = new User(username,password);
		boolean flag;
        
		if(username!=""){
        	flag=ModifyDao.modify(user);
	        if(flag){
	        	modify="验证通过!";
	        	Cookie cookie = new Cookie("username", username);//创建一个键值对的cookie对象
	        	cookie.setMaxAge(9000);//设置cookie的生命周期
	        	response.addCookie(cookie);//添加到response中
	        	System.out.println(cookie.getValue());
	        	response.sendRedirect("SetPassword.jsp");
	            return;
	        }
	        else{
	        	modify="用户名或密码错误!";
	        	request.getSession().setAttribute("modify", modify);
	        	request.getRequestDispatcher("Modify.jsp").forward(request, response);
	        }
		}
	    else{
	    	modify="请输入用户名（警号）!";
			request.getSession().setAttribute("modify", modify);
            request.getRequestDispatcher("Modify.jsp").forward(request, response);
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		doGet(request, response);
	}

}
