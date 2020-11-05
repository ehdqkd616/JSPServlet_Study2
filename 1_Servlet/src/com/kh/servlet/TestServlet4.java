package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet4 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
		
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("age", age);
		request.setAttribute("city", city);
		request.setAttribute("height", height);
		String foods = String.join(", ", foodArr);
		request.setAttribute("foods", foods);
		request.setAttribute("recommendation", recommendation);

		RequestDispatcher view = request.getRequestDispatcher("servlet/testServlet4End.jsp");
		
		System.out.println("name : " + name);
		System.out.println("gender : " + gender);
		System.out.println("age : " + age);
		System.out.println("city : " + city);
		System.out.println("height : " + height);
		for (int i = 0; i < foodArr.length; i++) {
			System.out.println("food : " + foodArr[i]);
		}
		
		view.forward(request, response);
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}

