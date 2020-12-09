package com.study.free.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.study.code.service.CommonCodeServiceImpl;
import com.study.code.service.ICommonCodeService;
import com.study.free.service.FreeBoardServiceImpl;
import com.study.free.service.IFreeBoardService;
import com.study.free.vo.FreeBoardVO;
import com.study.servlet.IController;

public class FreeBoardRegistController implements IController {

	private ICommonCodeService  codeService = new CommonCodeServiceImpl();
	private IFreeBoardService freeBoardService = new FreeBoardServiceImpl();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		FreeBoardVO free = new FreeBoardVO();		
		BeanUtils.populate(free, req.getParameterMap());
		
		free.setBoIp(req.getRemoteAddr());		
		freeBoardService.registBoard(free);
		
		return "redirect:/free/freeView.wow?boNo=" + free.getBoNo();
	}

}