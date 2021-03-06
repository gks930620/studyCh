package com.di.step2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceTestByXML {

	public static void main(String[] args) {
		
		// 스프링 설정을 읽어서 해당 빈을 받아서 실행		
		AbstractApplicationContext context 
		  = new GenericXmlApplicationContext("spring/step2.xml");
		
		// 컨트롤러 A 에서 BoardService 사용한다고 가정함
		BoardService boardService = context.getBean("boardService", BoardService.class);
		System.out.println("boardService=" + boardService);		
		boardService.getBoardList();	
		boardService.getBoard(28);		
		
		System.out.println("----------------------------");		
	  // 컨트롤러 B 에서 BoardService 사용한다고 가정함 
		BoardService boardService2 = context.getBean("boardService", BoardService.class);
		System.out.println("boardService2=" + boardService2);
		
		boardService2.getBoardList();
		boardService.getBoard(6);		
		
		context.close();
	}
	
}
