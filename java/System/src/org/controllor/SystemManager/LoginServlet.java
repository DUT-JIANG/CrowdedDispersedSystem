package org.controllor.SystemManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.model.SystemManage.LoginDao;
import org.model.SystemManage.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
		boolean flag;
		String message =null;
		String power=null;
        if(username!="" && password!="")
        {
            User user = new User(username,password);
        	flag = LoginDao.login(user);
        	System.out.println(flag);
	        if(flag){
	        	power=LoginDao.getPower(user);
	        	Cookie cookie1 = new Cookie("username", username);//创建一个键值对的cookie对象
	        	cookie1.setMaxAge(60*60*24);//设置cookie的生命周期
	        	response.addCookie(cookie1);//添加到response中
	        	System.out.println(cookie1.getValue());
	        	Cookie cookie2 = new Cookie("power", power);//创建一个键值对的cookie对象
	        	cookie2.setMaxAge(60*60*24);//设置cookie的生命周期
	        	response.addCookie(cookie2);//添加到response中
	        	System.out.println(cookie2.getValue());
	        	response.sendRedirect("Welcome.jsp");
	            return;
	        }else{
	        	message = "用户名或密码有误!";
	        	request.getSession().setAttribute("message", message);
	            request.getRequestDispatcher("Login.jsp").forward(request, response);
	            System.out.println(message);
	        return;
	        }
        }
        else {
        	message = "用户名或密码有误!";
        	request.getSession().setAttribute("message", message);
        	request.getRequestDispatcher("Login.jsp").forward(request, response);
            System.out.println(message);
            return;
        }
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		doGet(request, response);
	}

}
