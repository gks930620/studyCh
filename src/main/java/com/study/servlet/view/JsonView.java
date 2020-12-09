package com.study.servlet.view;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonView extends View {
	public JsonView() {
		this.contentType = "application/json; charset=UTF-8";
	}

	@Override
	public void render(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		resp.setContentType(this.contentType);
		PrintWriter out = resp.getWriter();
		// 실행 컨트롤러에서 속성에 "model" 이름으로 저장했다고 약속~~
		Object obj = req.getAttribute("model");
		if (obj != null) {
			ObjectMapper mapper = new ObjectMapper();
			String jsonResult = mapper.writeValueAsString(obj);
			String uri = req.getRequestURI();
			logger.debug("URI={}, JsonView is Call", uri);
			out.print(jsonResult);
			out.flush();
		} else {
			throw new ServletException("JsonView에 Model 이 존재하지 않습니다. ");
		}
	}
}