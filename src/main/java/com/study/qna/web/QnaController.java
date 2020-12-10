package com.study.qna.web;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.code.service.ICommonCodeService;
import com.study.code.vo.CodeVO;
import com.study.member.vo.MemberSearchVO;
import com.study.member.vo.MemberVO;
import com.study.qna.service.IQnaService;

import com.study.qna.vo.QnaSearchVO;
import com.study.qna.vo.QnaVO;

@Controller
@RequestMapping("/qna")
public class QnaController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	private ICommonCodeService codeService;

	@Inject
	private IQnaService qnaService;

	@ModelAttribute("jobList")
	public List<CodeVO> getJobList() {
		List<CodeVO> jobList = codeService.getCodeListByParent("JB00");
		return jobList;
	}

	@ModelAttribute("hobbyList")
	public List<CodeVO> gethobbyList() {
		List<CodeVO> hobbyList = codeService.getCodeListByParent("HB00");
		return hobbyList;
	}

	
	
	
	@RequestMapping("/qnaList.wow")
	public String qnaList(@ModelAttribute("searchVO") QnaSearchVO searchVO, Model model) throws Exception {

		List<QnaVO> qnas = qnaService.getQnaList(searchVO);
		model.addAttribute("qnas", qnas);
		return "qna/qnaList";
	}

	
	
	
}
