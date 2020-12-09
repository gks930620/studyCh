package com.study.servlet;

import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;


@SuppressWarnings("serial")
public class DriverLoader extends HttpServlet {

	@Override
	public void init() throws ServletException {		
		loadJDBCDriver();
		initConnectionPool();
	}
	
	private void loadJDBCDriver() {
		// 1. 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("fail to JDBC Driver ", e);
		}
	} // loadJDBCDriver
	
	
	private void  initConnectionPool() {		
		try {
			// 커넥션 풀이 새로운 커넥션을 생성할 때 사용할 커넥션 팩토리를 생성한다. 
			ConnectionFactory connFactory = 
					 new DriverManagerConnectionFactory(
							"jdbc:oracle:thin:@127.0.0.1:1521:xe","java","oracle");


			PoolableConnectionFactory poolableConnFactory 
			    = new PoolableConnectionFactory(connFactory, null);
			poolableConnFactory.setValidationQuery("select 1 from dual");
			
			GenericObjectPoolConfig poolConofig = new GenericObjectPoolConfig();
			poolConofig.setTimeBetweenEvictionRunsMillis(1000L *60L * 5L);  // 5분 
			poolConofig.setTestWhileIdle(true); 
			poolConofig.setMinIdle(4);
			poolConofig.setMaxTotal(4);
			
			GenericObjectPool<PoolableConnection> connectionPool 
			   = new GenericObjectPool<>(poolableConnFactory, poolConofig);
			poolableConnFactory.setPool(connectionPool);
			
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver =  
					(PoolingDriver)DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			driver.registerPool("study",connectionPool);
			System.out.println("DBCP 드라이버 등록 성공");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	} // initConnectPool
	
} // class