package org.controllor.SystemManager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        boolean flag = new UserDao().checkEmail(email);
        
        if(flag){
            request.setAttribute("msg", "此邮箱已被注册！");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }else{
            new UserDao().register(userName,email,password);
            request.setAttribute("msg", "欢迎您"+userName+",注册成功！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
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