package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet("/updateForm.me")
public class UpdateMemberForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateMemberForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
    	HttpSession session = request.getSession();
		Member sessionMember = (Member)session.getAttribute("loginUser");
		String loginUserId = sessionMember.getUserId();
//    	String loginUserId = ((Member)session.getAttribute("loginUser")).getUserId();
    	
    	Member member = new MemberService().selectMemeber(loginUserId);
    	
    	String page = null;
    	if(member != null) {
    		page = "WEB-INF/views/member/memberUpdateForm.jsp";
    		request.setAttribute("member", member);
    		request.getRequestDispatcher(page).forward(request, response);
    	}else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "회원수정 페이지에  접근 실패했습니다.");
		}		
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
