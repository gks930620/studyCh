package com.di.step5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("daoOracle")
public class BoardDaoOracle implements IBoardDao {
	private String username = "java";
	private String password = "oracle";
	
	private String driver; // = "oracle.jdbc.driver.OracleDriver";
	private String url;  //  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	public BoardDaoOracle(@Value("이해가 안되") String driver
			                 ,@Value("병준아빠가 애인이 있을까") String url) {
		super();
		this.driver = driver;
		this.url = url;
	}

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
