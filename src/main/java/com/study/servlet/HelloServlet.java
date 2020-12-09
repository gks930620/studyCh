package com.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿클래스는 HttpServlet 을 상속받아야 합니다.
// @WebServlet(urlPatterns = "*.wow")
public class HelloServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// 메모리에 적재된 후 바로 호출
		// 어플리케이션(서블릿)에 필요한 자원 초기화 
		System.out.println(getClass().getSimpleName() + "의 init 메서드가 호출");
		System.out.println("--- 김윤재, 박진형, 김연세, 박세연, 박병준 -----");
	}
		
	@Override
	public void destroy() {
			// 메모리에 제거되기 전 호출
			// 자원정리 (DB 커넥션, 외부 연계 호출관련) 
			System.out.println(getClass().getSimpleName() + "이 죽어요!!! 엉엉.. ");
			System.out.println("--- 다음 생애 다시 만나요~~ --");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자의 요청에 따른 결과를 제공 (html, json, file ...)
	
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + "병준아빠가 변했어요~</title>");
		out.println("</head>");
		out.println("<body>");
		for(int i = 0; i < 100; i++) {
			out.println("연세아빠 파이또!!! <br>");
		}
		out.println("</body>");
		out.println("</html>");
	}
	
	
	
	
}
