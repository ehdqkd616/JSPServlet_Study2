package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/* 
	<servlet>
		<servlet-name>NickCheckServlet</servlet-name>
		<servlet-class>member.controller.NickCheckServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>NickCheckServlet</servlet-name>
		<url-pattern>/nickCheck.me</url-pattern>
	</servlet-mapping>
*/

@WebServlet("/nickCheck.me")
public class NickCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NickCheckServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.setCharacterEncoding("UTF-8");
		
		String userNick = request.getParameter("inputNick");
	
		int result = new MemberService().nickCheck(userNick);
		
		request.setAttribute("result", result);
		request.setAttribute("checkedNick", userNick);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/member/nickCheckForm.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
