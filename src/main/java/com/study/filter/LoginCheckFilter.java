package com.study.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.login.vo.UserVO;

// @WebFilter(urlPatterns = "/member/*" )
public class LoginCheckFilter implements Filter {

	// Java 8 이상 + Servlet 4.0 이상 인터페이스에서 기본 메서드 가능 
		
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 세션을 구하는 방법 (현재 요청과 관련이 있는 request에서 구할 수 있습니다.)
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp =  (HttpServletResponse)response; 
		HttpSession session = req.getSession();
		UserVO loginVO = (UserVO)session.getAttribute("USER_INFO");
		System.out.printf("[%s] 실행 \n", getClass().getSimpleName());
		if(loginVO == null) {
			// 결과를 이곳에서 생성해서 내보내자...
			System.out.printf("IP : %s, URI=%s 비회원 \n",req.getRemoteAddr(),  req.getRequestURI());

			// 리다이렉트 방식 (서버에서 리다이렉트 헤더생성  ->  브라우저가 이동하는) 
			resp.sendRedirect(req.getContextPath() + "/login/login.jsp");
			
			// 포워드 방식 (서버내부에서 페이지로 이동하는)
			// RequestDispatcher rd = req.getRequestDispatcher("/login/login.jsp");
			// rd.forward(request, response);
		} else {
			// 계속 진행(다음 필터나 jsp) 
			chain.doFilter(request, response);
			// chain.doFilter 를 중복되지 않게 주의해 주세요 
			// chain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}






