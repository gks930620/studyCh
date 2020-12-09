package com.di.step1;

public class BoardServiceTest {

	public static void main(String[] args) {
		// 객체가 한개만 생성되게 하려면 어떻게 해야 될까??
		
		// 컨트롤러 A 에서 BoardService 사용한다고 가정함 
		BoardService boardService = new BoardService();
		System.out.println("boardService=" + boardService);
		boardService.myInit();		
		boardService.getBoardList();	
		boardService.getBoard(28);		
		boardService.myDestroy();		
		
		System.out.println("----------------------------");
		
	  // 컨트롤러 B 에서 BoardService 사용한다고 가정함 
		BoardService boardService2 = new BoardService();
		System.out.println("boardService2=" + boardService2);
		boardService2.myInit();
		boardService2.getBoardList();
		boardService.getBoard(6);		
		boardService2.myDestroy();
		
	}
	
}
