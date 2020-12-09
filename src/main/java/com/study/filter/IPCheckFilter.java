package com.study.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// @WebFilter(urlPatterns = "*.jsp")
public class IPCheckFilter implements Filter {
	private Map<String, String> ipMap ;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ipMap = new HashMap<String, String>();
		ipMap.put("127.0.0.1", "A");
		ipMap.put("0:0:0:0:0:0:0:1", "A");
		ipMap.put("192.168.10.2", "A");
		ipMap.put("192.168.10.114", "D");
		ipMap.put("192.168.10.4", "A");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 // 매핑은 : "*.jsp" 
		 // "A" 이면 그대로 들여보내시고 
		 // "D" 이면 직접 출력 
		 //    "해당 아이피 192.168.10.zz 는 거부된 아이피입니다. 
		 //     문의사항은 반장님에게 연락주세요"
		 // 등록안된 아이피는  무조건 "/index.jsp" 포워드 
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	
}
