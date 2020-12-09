package com.study.free.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.code.service.CommonCodeServiceImpl;
import com.study.code.service.ICommonCodeService;
import com.study.code.vo.CodeVO;
import com.study.free.service.FreeBoardServiceImpl;
import com.study.free.service.IFreeBoardService;
import com.study.servlet.IController;

public class FreeBoardFormController implements IController {

	private ICommonCodeService  codeService = new CommonCodeServiceImpl();
	private IFreeBoardService freeBoardService = new FreeBoardServiceImpl();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<CodeVO> categoryList = codeService.getCodeListByParent("BC00");		
		req.setAttribute("categoryList", categoryList);
		
		return "free/freeForm";
	}

}



