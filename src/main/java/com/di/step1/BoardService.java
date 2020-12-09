package com.di.step1;

public class BoardService {
/*
	// 싱글턴 패턴으로 만들어 보아요~ (시험문제)
	// 1. 생성자는 숨김 (private) , new 를 사용 못하게 
	// 2. 정적 클래스변수 instance 선언 
	// 3. instance 의 getter 선언 (내부에서 객체를 생성)	
	
	private static BoardService instance;
	
	private BoardService() {}
	
	public static BoardService getInstance() {
		if(instance == null) {
			instance = new BoardService();
		}
		return instance;
	}
*/	
	
	// DB가 변경됨에 따라 DAO를 사용하는 서비스에 변화가 발생함	
	private IBoardDao boardDao = new BoardDaoMySql();  // new BoardDaoOracle();
	
	public void getBoardList() {
		boardDao.getBoardList();
	}
	
	
	public void getBoard(int boNo) {
		boardDao.getBoard(boNo);
	}
		
	
	public void myInit() {
		// 객체에서 필요한 초기화 작업
		System.out.println(">>>>> " + Thread.currentThread().getStackTrace()[1].getMethodName());		
		boardDao.getConnectionInfo();	
		System.out.println("<<<<< " + Thread.currentThread().getStackTrace()[1].getMethodName() );
	}
	
	public void myDestroy() {
		// 객체가 소멸될 때 불필요한 자원 정리 작업
		System.out.println(">>>>> myDestroy");
		System.out.println("자원정리를 하였습니다.");
		System.out.println("나 죽어요...이젠 안녕~~");
		System.out.println("<<<<< myDestroy");
	}	
	
}
