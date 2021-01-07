package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 
<servlet>
		<servlet-name>SignUpFormServlet</servlet-name>
		<servlet-class>member.controller.SignUpFormServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>SignUpFormServlet</servlet-name>
		<url-pattern>/signUpForm.me</url-pattern>
	</servlet-mapping>
*/

@WebServlet("/signUpForm.me")
public class SignUpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public SignUpFormServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.sendRedirect("WEB-INF/views/member/signUpForm.jsp");
		request.getRequestDispatcher("WEB-INF/views/member/signUpForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
