package org.controllor.SystemManager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.model.SystemManage.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
        response.setContentType("登录界面.jsp;charset=utf-8");
        
        String username = request.getParameter("username");
        String password  = request.getParameter("paeeword");
       
        User user = new User(username,password);
		boolean flag = LoginDao.login(user);
        
        if(flag){
            request.setAttribute("msg", "用户名或密码错误！");
            request.getRequestDispatcher("登录界面.jsp").forward(request, response);
            return;
        }else{
            request.setAttribute("username", username);
            request.getRequestDispatcher("欢迎界面.jsp").forward(request, response);
        return;
        }
        
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
