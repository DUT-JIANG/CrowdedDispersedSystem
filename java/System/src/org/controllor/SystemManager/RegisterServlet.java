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
    private static final long serialVersionUID = 1L;
       
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
        
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        

        boolean flag = new LoginDao().register(username,password);
        
        if(!flag){
            request.setAttribute("注册失败，用户名已存在", flag);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }else{
            request.setAttribute("userName", userName);
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
            return;
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