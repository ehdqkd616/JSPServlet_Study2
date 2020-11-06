package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/* 
<servlet>
		<servlet-name>InsertMemberServlet</servlet-name>
		<servlet-class>member.controller.InsertMemberServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>InsertMemberServlet</servlet-name>
		<url-pattern>/insert.me</url-pattern>
	</servlet-mapping>
*/

@WebServlet(urlPatterns = "/insert.me", name = "InsertMemberServlet")
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertMemberServlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String joinUserId = request.getParameter("joinUserId");
		String joinUserPwd = request.getParameter("joinUserPwd");
		String joinUserPwd2 = request.getParameter("joinUserPwd2");
		String joinUserName = request.getParameter("userName");
		String nickName = request.getParameter("nickName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String[] interests = request.getParameterValues("interest");
		String interest = ""; // ,로 묶기 (ex: 운동, 등산, 낚시)
		if (interests != null) {
			for (int i = 0; i < interests.length; i++) {
				if(i == interests.length - 1)
					interest += interests[i];
				else
					interest += interests[i] + ",";
			}
		}
		
		Member member = new Member(joinUserId, joinUserPwd, joinUserName, nickName, phone, email, address, interest);
		System.out.println(member);
		
		int result = new MemberService().insertMember(member);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath());
			request.getSession().setAttribute("msg", "회원가입에 성공하였습니다.");
		} else {
			request.getSession().setAttribute("msg", "회원가입에 실패했습니다.");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
