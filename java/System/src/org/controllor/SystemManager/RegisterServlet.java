package org.controllor.SystemManager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.model.SystemManage.*;

//控制器层，接收view请求，并转发给model
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
        response.setContentType("注册界面.jsp;charset=utf-8");
        
        String username   = request.getParameter("username");
        String password   = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String realname   = request.getParameter("realname");
        String unit       = request.getParameter("unit");
        String position   = request.getParameter("position");
        String id         = request.getParameter("id");
        String birthdate  = request.getParameter("birthdate");
        String jointime   = request.getParameter("jointime");
        String tel        = request.getParameter("tel");
        String email      = request.getParameter("email");
        
        if(!password.equals(repassword)) {
        	request.setAttribute("两次密码不一致",password);
            request.getRequestDispatcher("注册界面.jsp").forward(request, response);
        }
        else {
        	User temp = new User(username,id,tel,email);
        	User user = new User(username,password,realname,unit,position,id,birthdate,jointime,tel,email);
        	boolean flag = RegisterDao.verify(temp);
        	if(flag) {
        		RegisterDao.register(user);
        	}
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}