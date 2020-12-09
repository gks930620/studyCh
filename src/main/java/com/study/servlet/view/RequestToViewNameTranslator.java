package com.study.servlet.view;

import javax.servlet.http.HttpServletRequest;

public class RequestToViewNameTranslator {
	
	public static String getViewName(HttpServletRequest req) {
    // 뷰이름이 지정되지 않은 경우 현재 요청 URI 정보를 뷰이름으로 사용한다.
		String uri = req.getRequestURI();
		String uriBaseViewName = uri;
		
		// 윤재아빠 숙제(월요일날)  
    // 과제 : 아래의 조건을 만족하도록 변수 uriBaseViewName 을 변경하시오.
    // uriBaseViewName에서 컨텍스트 경로, 확장자, 세미콜론이 있다면 제거한다.
    // 예 : "/study3/free/freeList.wow;JSESSIONID=MILKIS1004" -> "free/freeList"
		
		uriBaseViewName = uriBaseViewName.substring(req.getContextPath().length() + 1);
		
		if(uriBaseViewName.lastIndexOf(";") > 0) {
			uriBaseViewName = uriBaseViewName.substring(0,uriBaseViewName.lastIndexOf(";"));
		}
		
		if(uriBaseViewName.lastIndexOf(".") > 0) {
			uriBaseViewName = uriBaseViewName.substring(0,uriBaseViewName.lastIndexOf("."));
		}		
		return uriBaseViewName;
	}
	
}