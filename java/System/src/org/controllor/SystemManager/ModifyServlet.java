package org.controllor.SystemManager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.model.SystemManage.LoginDao;
import org.model.SystemManage.ModifyDao;
import org.model.SystemManage.User;

public class ModifyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
       
        
        User user = new User(username,password);
		boolean flag = ModifyDao.modify(user);
        
        if(flag){
            request.setAttribute("msg", "用户名或密码错误！");
            request.getRequestDispatcher("登录界面.jsp").forward(request, response);
            return;
        }else{
            request.setAttribute("msg", "登录成功");
            request.getRequestDispatcher("欢迎界面.jsp").forward(request, response);
        return;
        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		doGet(request, response);
	}

}
