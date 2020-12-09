package com.di.step1;

public class BoardDaoOracle implements IBoardDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String username = "java";
	private String password = "oracle";
	
	@Override
	public void getConnectionInfo() {
		System.out.println("DAO=" + this);
		System.out.printf("[Oracle] 커넥션정보%n  Driver=%s\n  URL=%s\n", driver, url);
	}
	
	@Override
	public void getBoardList() {		
		System.out.println("[Oracle] 게시판 정보를 조회 했습니다.");
	}

	@Override
	public void getBoard(int boNo) {
		System.out.println("[Oracle] 글번호=" + boNo +" 를 조회 했습니다.");	
	}
	
}
