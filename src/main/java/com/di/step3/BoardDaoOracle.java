package com.di.step3;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("daoOracle")
public class BoardDaoOracle implements IBoardDao {
	@Value("#{app['db.username']}")
	private String username;
	@Value("#{app['db.password']}")
	private String password;
	
	// @Autowired @Qualifier("threeLine")
	// @Autowired가 잘 안되네요...
	@Resource(name="threeLine")
	private List<String> 포기한라인;
	
	private String driver; // = "oracle.jdbc.driver.OracleDriver";
	private String url;  //  = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	public BoardDaoOracle(@Value("Oracle 11g XE") String driver
			                 ,@Value("ysBabo") String url) {
		super();
		this.driver = driver;
		this.url = url;
	}

	@Override
	public void getConnectionInfo() {
		System.out.println("DAO=" + this);
		System.out.printf("[Oracle] 커넥션정보%n  Driver=%s\n  URL=%s\n", driver, url);
		System.out.printf("         username=%s\n  password=%s\n", username, password);
	}
	
	@Override
	public void getBoardList() {		
		System.out.println(">>>>>>>>>>>>>>>");
		System.out.println(포기한라인);
		System.out.println("<<<<<<<<<<<<<<<");		
		System.out.println("[Oracle] 게시판 정보를 조회 했습니다.");
	}

	@Override
	public void getBoard(int boNo) {
		System.out.println("[Oracle] 글번호=" + boNo +" 를 조회 했습니다.");	
	}
	
}
