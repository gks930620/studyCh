package com.study.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {
	//  Vector, ArrayList, LinkedList , List 
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("malja", "사랑해요 말자~~");
		map.put("milkis", "사랑해요 밀키스!!");
		map.put("hate", "연세아빠는 상담이 필요해~~~");
		map.put("sunja", "JSP 책을 미리 보시는게 좋아요~~");
		// 맵에 들어 있는 정보(키, 값)를 출력하는 방법 3가지 이상 구글링해서 구현
		// 실행 Ctrl + F11 -> Java Application 으로
		
		// System.out.println(map.get("hate"));
		// Enumeration(열거, 나열하다)  , Iterator (반복자) 
		
		// Enumeration java 1.0 : en.hasMoreElement(), en.nextElement();
		// Iterator    java 1.2 : it.hasNext(), it.next();
		System.out.println("Case keySet ");
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + " = " + map.get(key));
		}
		
		System.out.println("Case entrySet ");
		Iterator<Map.Entry<String, Object>> ent = map.entrySet().iterator();
		while (ent.hasNext()) {
			Entry<String, Object> entry = ent.next();
			System.out.println(entry.getKey() + " =" + entry.getValue());
		}
		
		// Enhanced for  : java 1.5 	
		System.out.println("Case entrySet for each ");
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		
		// lambda : java 1.8
		System.out.println("Case lambda forEach ");
		map.forEach((k, v) -> System.out.println( k + " = " + v));
	}

}
