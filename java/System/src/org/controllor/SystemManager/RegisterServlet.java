package org.controllor.SystemManager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.model.Query;
import org.model.SystemManage.*;

//控制器层，接收view请求，并转发给model
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
     static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理注册
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        String username   = request.getParameter("username");
        String password   = request.getParameter("password");
        String realname   = request.getParameter("realname");
        String unit       = request.getParameter("unit");
        String position   = request.getParameter("position");
        String id         = request.getParameter("id");
        String birthdate  = request.getParameter("birthdate");
        String jointime   = request.getParameter("jointime");
        String tel        = request.getParameter("tel");
        String email      = request.getParameter("email");
        	String message=null;
        	User temp = new User(username,id,tel,email);
        	User user = new User(username,password,realname,unit,position,id,birthdate,jointime,tel,email);
        	boolean flagU = RegisterDao.verifyU(temp);
        	boolean flagI = RegisterDao.verifyI(temp);
        	boolean flagT = RegisterDao.verifyT(temp);
        	boolean flagE = RegisterDao.verifyE(temp);
        	if(username!="")
	        	if(flagU) {
	        		if(flagI)
	        		{
	        			if(flagT)
	        			{
	        				if(flagE)
	        				{
	        					RegisterDao.register(user);
	        					message="注册成功!";
	        					request.getSession().setAttribute("message", message);
	        		            request.getRequestDispatcher("登录界面.jsp").forward(request, response);
	        				}
	        				else
	        				{
	        					message = "邮箱已被注册";
	        		        	request.getSession().setAttribute("message", message);
	        		            request.getRequestDispatcher("注册界面.jsp").forward(request, response);
	        		            System.out.println(message);
	        		            return;
	        				}
	        			}
	        			else
	    				{
	    					message = "电话号码已被注册";
	    		        	request.getSession().setAttribute("message", message);
	    		            request.getRequestDispatcher("注册界面.jsp").forward(request, response);
	    		            System.out.println(message);
	    		            return;
	    				}
	        		}
	        		else
					{
						message = "身份证号已被注册";
			        	request.getSession().setAttribute("message", message);
			            request.getRequestDispatcher("注册界面.jsp").forward(request, response);
			            System.out.println(message);
			            return;
					}
	        	}
	        	else
				{
					message = "用户名（警号）已被注册";
		        	request.getSession().setAttribute("message", message);
		            request.getRequestDispatcher("注册界面.jsp").forward(request, response);
		            System.out.println(message);
		            return;
				}
        	else
        	{
        		message = "请输入用户名（警号）!";
        		request.getSession().setAttribute("message", message);
        		request.getRequestDispatcher("注册界面.jsp").forward(request, response);
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