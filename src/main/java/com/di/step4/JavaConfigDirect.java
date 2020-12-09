package com.di.step4;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaConfigDirect {
	
	@Bean
	public IBoardDao getDaoOracle() {
		BoardDaoOracle dao = new BoardDaoOracle("Oracle8Driver"
																		, "jdbc:oracle:thin:@127.0.0.1:1521:babo");
		dao.setUrl("연세바보");
		dao.setDriver("babo");
		return dao;
	}
	
	@Bean
	public IBoardDao getDaoMySql() {
		BoardDaoMySql dao = new BoardDaoMySql("OracleMySql"
				                     , "MySql은 현재 Oracle사 제품입니다.");
		return dao;
	}
		
	@Bean(name="boardService", initMethod="myInit",destroyMethod = "myDestroy" )
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE) // "prototype"
	public BoardService getBoardService() {
		BoardService boardService = new BoardService(getDaoMySql());
		return boardService;
	}
	
	
}
