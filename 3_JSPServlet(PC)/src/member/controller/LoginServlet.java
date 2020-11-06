package member.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;


/* 
	<servlet>
  		<servlet-name>LoginServlet</servlet-name>
  		<servlet-class>member.controller.LoginServlet</servlet-class>
  	</servlet>
  	<servlet-mapping>
  		<servlet-name>LoginServlet</servlet-name>
  		<url-pattern>/login.me</url-pattern>
  	</servlet-mapping>
 */

@WebServlet(urlPatterns = "/login.me", name="LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		System.out.println("LoginServlet userId : " + userId);
		System.out.println("LoginServlet userPwd : " + userPwd);
		
		Member member = new Member(userId, userPwd);
		Member loginUser = new MemberService().loginMember(member);
		
		if(loginUser != null) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(600);
			session.setAttribute("loginUser", loginUser);
			
			/*
			 	RequestDispatcher.forward()		vs		response.sendRedirect	
			 */
			response.sendRedirect(request.getContextPath());
			
		} else {
			request.setAttribute("msg", "로그인 실패");
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
			view.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
