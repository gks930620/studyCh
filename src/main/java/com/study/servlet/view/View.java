package com.study.servlet.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class View {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	protected String contentType = "text/html; charset=UTF-8";
	protected String viewName;
	public abstract void render(HttpServletRequest req, HttpServletResponse resp) throws Exception;

}
