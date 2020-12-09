package com.study.util;

public class MyUtil {
	
	
	
	public static String makeDan(int dan) {
		StringBuffer sb = new StringBuffer();
		sb.append("<td>");
		sb.append("<h4>" + dan + "단 </h4>");
		sb.append("<ul>");
		for(int i = 1; i <= 9; i++) {
			sb.append("<li>" + dan + " * " + i + " = "+ (dan * i) );
		}
		sb.append("</ul>");
		sb.append("</td>");
		return sb.toString();
	}
	
	
	public static String love(int cnt){
		return love(cnt,"말자");		
	}
	
	public static String love(int cnt, String name){
		long startTime = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < cnt; i++){
			sb.append("내 사랑 " + name + "!!<br>");
		}
		System.out.printf("love %d번 소요시간 = %dms\n", 
				            cnt, (System.currentTimeMillis()-startTime) );
		return sb.toString();
	}
}
