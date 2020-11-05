package action.summary.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/handler.do")
public class HandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HandlerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		char gender = request.getParameter("gender").charAt(0);
		int age = Integer.parseInt(request.getParameter("age"));
		
		
		String page = "03_summary/"+request.getParameter("view");
		
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("age", age);
		
		
		
		request.getRequestDispatcher(page).forward(request, response);
		
		
		// 01_handler.jsp에서 보낸 값들을 받아와서
		// 해당 view에 다시 전송 ==> input type=hidden name=view value=???
				
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
