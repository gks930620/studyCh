package com.study.servlet.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectView extends View {
	
	public RedirectView(String viewName) {
		this.viewName = viewName;
	}

	@Override
	public void render(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if (viewName.startsWith("/")) {
			resp.sendRedirect(req.getContextPath() + viewName);
		} else {
			resp.sendRedirect(viewName);
		}
	}
}