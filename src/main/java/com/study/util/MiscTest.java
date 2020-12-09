package com.study.util;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;
import com.study.login.vo.UserVO;

public class MiscTest {
	// miscellaneous 여러 가지 종류의, 이것저것 다양한 
	
	public static void main(String[] args) throws Exception {
		UserVO user = new UserVO("milkis", "싸랑행요", "1004", "MANAGER");		
		System.out.println(user.toString());
		// 자바객체를  -> Json 문자열로 생성 
		//   {"userId" : "milkis", "userName" : "싸랑해요", ....}
		// 1. 직접코딩 
		// String json ="{\"userId\" : \"" + user.getUserId() + "\", ..}";
		// 
		// 2. 라이브러리 사용 (구글 Gson, fasterxml 의 Jackson)
		System.out.println("---------------------------------");
//		Gson gson = new Gson();
//		String json = gson.toJson(user);
//		System.out.println(json);		
		
		System.out.println("---------------------------------");
		ObjectMapper mapper = new ObjectMapper();
		String json2 = mapper.writeValueAsString(user);
		System.out.println(json2);
		
  	// 3. 라이브러리 사용 (구글 Gson, fasterxml 의 Jackson)
		// JSON 문자열을 객체에 넣기 
		String orig = "{\"userId\":\"malja\",\"userName\":\"말자\",\"userPass\":\"1004\",\"userRole\":\"MANAGER\"}";
		
//		// Gson을 사용해서 객체에 담기 (윤재)		
//		UserVO user2 = gson.fromJson(orig, UserVO.class);
//		System.out.println(user2);		
		
		// Jackson을 사용해서 객체에 담기 (재룡)		
		UserVO user3 = mapper.readValue(orig, UserVO.class);
		System.out.println(user3);
		
		
	}
}
