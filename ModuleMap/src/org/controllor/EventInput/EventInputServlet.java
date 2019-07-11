package org.controllor.EventInput;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.model.Checks;

@WebServlet("/EventInputServlet")
public class EventInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html;charset=utf-8");
		//EventName=&EventType=恐怖袭击&Mode=地址模式&origin=&destination=&Crowd=&policeId=&Time=
		request.setCharacterEncoding("utf-8");
		String EventName = request.getParameter("EventName");
		String EventType = (String) request.getParameter("EventType");
		String Mode = (String) request.getParameter("Mode");
		String origin = (String) request.getParameter("origin");
		String destination = (String) request.getParameter("destination");
		String Crowd = (String) request.getParameter("Crowd");
		String policeId = (String) request.getParameter("policeId");
		String Time = (String) request.getParameter("Time");
		String status=null;
		status = (String) request.getParameter("status");
		if(status.equals("1")) {
			System.out.println("status == 1");
		}
		System.out.println(status);
		//消息合法性检查
		boolean illeagal =false;
		illeagal |= Checks.checkNULL(EventName);
		illeagal |= Checks.checkNULL(EventType);
		illeagal |= Checks.checkNULL(Mode);
		illeagal |= Checks.checkNULL(origin);
		illeagal |= Checks.checkNULL(destination);
		illeagal |= Checks.checkNULL(Crowd);
		illeagal |= Checks.checkNULL(policeId);
		illeagal |= Checks.checkNULL(Time);

		illeagal |= Checks.checkEmpty(EventName);
		illeagal |= Checks.checkEmpty(EventType);
		illeagal |= Checks.checkEmpty(Mode);
		illeagal |= Checks.checkEmpty(origin);
		illeagal |= Checks.checkEmpty(destination);
		illeagal |= Checks.checkEmpty(Crowd);
		illeagal |= Checks.checkEmpty(policeId);
		illeagal |= Checks.checkEmpty(Time);
		if(illeagal) {
			System.out.println("[EventInput]Null Message");
			String message = "";
			request.getSession().setAttribute("message", message);
			request.getSession().setAttribute("status", "2");
	        request.getRequestDispatcher("填写演练事件.jsp").forward(request, response);
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	    request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		doGet(request, response);
	}

}
