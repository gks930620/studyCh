package com.study.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSessionFactory {
	
	private static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			System.out.println("-----------------START ----------------------");
			String resource = "mybatis/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("------------------ END ---------------------");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

}
