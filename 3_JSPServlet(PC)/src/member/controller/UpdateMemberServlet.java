package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;


@WebServlet("/update.me")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateMemberServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("joinUserId");
		String userName = request.getParameter("userName");
		String nickName = request.getParameter("nickName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String interests[] = request.getParameterValues("interest");
		String interest = "";
		if(interests != null) {
			interest = String.join(", ", interests);
		}
		
		Member member = new Member(userId, null, userName, nickName, phone, email, address, interest, null, null, null);
		
		int result = new MemberService().updateMember(member);
		
		String page = null;
		if(result > 0) {
			page = "/myPage.me";
			request.setAttribute("msg", "회원 수정에 성공하였습니다.");
		}else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "회원 수정에 실패하였습니다.");
		}
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
