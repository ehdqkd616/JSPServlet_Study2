package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/* 
	<servlet>
		<servlet-name>LogoutServlet</servlet-name>
		<servlet-class>member.controller.LogoutServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>LogoutServlet</servlet-name>
		<url-pattern>/logout.me</url-pattern>
	</servlet-mapping>
*/

@WebServlet("/logout.me")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LogoutServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate(); // 세션 무효화
		
		response.sendRedirect(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
