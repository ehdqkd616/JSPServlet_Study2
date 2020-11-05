package ajax.jquery.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ajax.jquery.model.vo.User;

/**
 * Servlet implementation class JQueryAjaxServlet12
 */
@WebServlet("/jQueryTest12.do")
public class JQueryAjaxServlet12 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JQueryAjaxServlet12() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HashMap<String, User> userMap = new HashMap<String, User>();
		userMap.put("김연우", new User(1, "김연우", "한국"));
		userMap.put("타일러 라쉬", new User(2, "타일러 라쉬", "미국"));
		userMap.put("쯔위", new User(3, "쯔위", "중국"));
		userMap.put("노다메", new User(4, "노다메", "일본"));
		userMap.put("리사", new User(5, "리사", "태국"));
		userMap.put("알베르토 몬디", new User(6, "알베르토 몬디", "이탈리아"));
		userMap.put("샘 오취리", new User(7, "샘 오취리", "가나"));
		
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(userMap, response.getWriter());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
