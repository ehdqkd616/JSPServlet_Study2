package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/* 
	<servlet>
		<servlet-name>CheckIdServlet</servlet-name>
		<servlet-class>member.controller.CheckIdServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>CheckIdServlet</servlet-name>
		<url-pattern>/checkId.me</url-pattern>
	</servlet-mapping>
*/

@WebServlet("/checkId.me")
public class CheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckIdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
//		String userId = request.getParameter("inputId");
		String userId = request.getParameter("userId");	
		int result = new MemberService().checkId(userId);
		
//		System.out.println(result);
//		request.setAttribute("result", result);
//		request.setAttribute("checkedId", userId);
//		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/member/idCheckForm.jsp");
//		view.forward(request, response);
		
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.append("fail");
		} else {
			out.append("success");
		}
		
		out.flush();
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
