package com.di.step5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;


@Repository("daoMysql")
public class BoardDaoMySql implements IBoardDao {
	private String username = "java";
	private String password = "oracle";
	
	private String driver; // = "com.mysql.jdbc.Driver";
	private String url; //  = "jdbc:mysql://localhost/dev";
	
	public BoardDaoMySql(@Value("철희") String driver, @Value("할아버지") String url) {
		super();
		this.driver = driver;
		this.url = url;
	}

	@Override
	public void getConnectionInfo() {
		System.out.println("DAO=" + this);		
		System.out.printf("[MySql] 커넥션정보%n  Driver=%s\n  URL=%s\n", driver, url);
	}
	
	@Override
	public void getBoardList() {	
		System.out.println("[MySql] 게시판 정보를 조회 했습니다.");
	}


	@Override
	public void getBoard(int boNo) {
		System.out.println("[MySql] 글번호=" + boNo +"  를 조회 했습니다.");
	}


	
	
	
}
