package com.study.free.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.code.service.CommonCodeServiceImpl;
import com.study.code.service.ICommonCodeService;
import com.study.free.service.FreeBoardServiceImpl;
import com.study.free.service.IFreeBoardService;
import com.study.servlet.IController;

public class FreeBoardDeleteController implements IController {

	private ICommonCodeService  codeService = new CommonCodeServiceImpl();
	private IFreeBoardService freeBoardService = new FreeBoardServiceImpl();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		return "free/delete";
	}

}



