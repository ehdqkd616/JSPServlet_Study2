package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 
	<servlet>
		<servlet-name>CheckIdFormServlet</servlet-name>
		<servlet-class>member.controller.CheckIdFormServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>CheckIdFormServlet</servlet-name>
		<url-pattern>/checkIdForm.me</url-pattern>
	</servlet-mapping>
*/

@WebServlet("/checkIdForm.me")
public class CheckIdFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckIdFormServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		request.getRequestDispatcher("WEB-INF/views/checkIdForm.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
