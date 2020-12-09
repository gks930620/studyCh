package com.study.servlet.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JstlView extends View {
	private String prefix = "";
	private String suffix = "";

	public JstlView(String viewName, String prefix, String suffix) {
		this.viewName = viewName;
		this.prefix = (prefix != null ? prefix : "");
		this.suffix = (suffix != null ? suffix : "");
	}

	@Override
	public void render(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String jspPath = this.prefix + this.viewName + this.suffix;
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(jspPath);
		dispatcher.forward(req, resp);
	}
}
