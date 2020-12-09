package com.study.servlet.handler;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;

import com.study.servlet.IController;

public class UrlHandlerMapping {
	
  // URI와 Controller를 맵핑한 정보 저장
	public Map<String, IController> handlerMap = new HashMap<String, IController>();

	public UrlHandlerMapping(ServletContext app, String contextConfigLocation) throws Exception {
		
		Properties prop = new Properties();
		String configFilePath = app.getRealPath(contextConfigLocation);		
		prop.load(new FileReader(configFilePath));
		
		Iterator<?> keyItr = prop.keySet().iterator();
		while (keyItr.hasNext()) {
			String uri = (String) keyItr.next();
			String className = prop.getProperty(uri);
			Class<?> handlerClass = Class.forName(className);
			IController handler = (IController) handlerClass.newInstance();			
			handlerMap.put(uri, handler);
			System.out.printf("%s %s 등록 성공!! \n",uri, className);
		}
	}

	public IController getHandler(String uri) {
		return handlerMap.get(uri);
	}
}