package org.controllor.SchemeMake;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.model.Checks;




/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/SchemeMakeServlet")
public class SchemeMakeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		init(request,response);
        String origin = request.getParameter("origin");
        String destionation = request.getParameter("destionation");
        String mode = request.getParameter("mode");
        boolean illeagal = false;
        illeagal |= Checks.checkNULL(origin);
        illeagal |= Checks.checkNULL(destionation);
        illeagal |= Checks.checkEmpty(origin);
        illeagal |= Checks.checkNULL(destionation);
        if(illeagal) {
        	System.out.println("[SchemeMakeServlet] illeagal submit");
        	request.setAttribute("Message", "参数错误");
            request.getRequestDispatcher("SchemeMake.jsp").forward(request, response);
            return;
        }
        
        
        
        
        
        
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		doGet(request, response);
	}
	


}