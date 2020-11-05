package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		System.out.println("서블릿 실행");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String height = request.getParameter("height");
		String[] foodArr = request.getParameterValues("food");
		
		String recommendation = "";
		
		switch(age) {
		case "10대 미만": recommendation = "엄마"; break;
		case "10대": recommendation = "친구"; break;
		case "20대": recommendation = "연인"; break;
		case "30대": recommendation = "돈"; break;
		case "40대": recommendation = "가족"; break;
		case "50대": recommendation = "시간"; break;
		
		}

		System.out.println("name : " + name);
		System.out.println("gender : " + gender);
		System.out.println("age : " + age);
		System.out.println("city : " + city);
		System.out.println("height : " + height);
		for (int i = 0; i < foodArr.length; i++) {
			System.out.println("food : " + foodArr[i]);
		}

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>개인정보 출력화면</title>");
		out.println("<style>");
		out.println("h2{color: red;}");
		out.println("span.name{color: orange; font-weight: bold;}");
		out.println("span.gender{color: yellow; font-weight: bold; background-color: black;}");
		out.println("span.age{color: green; font-weight: bold;}");
		out.println("span.city{color: blue; font-weight: bold;}");
		out.println("span.height{color: navy; font-weight: bold;}");
		out.println("span.food{color: purple; font-weight: bold;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>개인 취향 테스트 결과(POST)</h2>");
		out.printf("<span class='name'>%s</span>님은 ", name);
		out.printf("<span class='age'>%s</span>이시며, ", age);
		out.printf("<span class='city'>%s</span>에 사는 ", city);
		out.printf("키 <span class='height'>%s</span>cm인, ", height);
		out.printf("<span class='gender'>%s</span>입니다. ", gender);
		out.printf("좋아하는 음식은 <span class='food'>");
		for (int i = 0; i < foodArr.length; i++) {
			if (i == 0) {
				out.printf("%s", foodArr[i]);
			} else {
				out.printf(", %s", foodArr[i]);
			}
		}
		out.println("</span>입니다.");
		out.println("<hr>");
		out.println("<h3>" + age + "에 맞는 선물 추천</h3>");
		out.println("'" + recommendation + "' 선물은 어떠신가요?");
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
