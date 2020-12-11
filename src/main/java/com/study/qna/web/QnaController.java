package com.study.qna.web;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.groups.Default;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.code.service.ICommonCodeService;
import com.study.code.vo.CodeVO;
import com.study.common.valid.ModifyType;
import com.study.common.valid.RegistType;
import com.study.common.vo.ResultMessageVO;
import com.study.exception.BizNotFoundException;
import com.study.exception.BizPasswordNotMatchedException;
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
	
	@Inject
	MailSendService mss;
		
	// @ModelAttribute 는 요청 메시드 진입전에 
	// 먼저 동작하여 모델에 저장해줍니다.
	// 해당 이름의 모델이 이미 존재하는 경우는 수행을 하지 않습니다. 
	@ModelAttribute("categoryList")
	public List<CodeVO> getCategoryList() {
		logger.debug("기백아빠. 고깃집 파이팅~~~");
		List<CodeVO> categoryList = codeService.getCodeListByParent("BC00");		
		return categoryList; 
	}
	
	@RequestMapping("/qnaList.wow")
	public String qnaList(@ModelAttribute("searchVO") QnaSearchVO searchVO
			           , Model model) throws Exception {
		// 커맨드객체(VO)는 자동으로 모델에 저장 
		//  이름은 클래스명의 첫글자 소문자로 해서 "freeBoardSearchVO"  
		//  @ModelAttribute 를 사용해서 이름을 변경 할 수 있다.		
			
		List<QnaVO> li = qnaService.getQnaList(searchVO);
		
		// model.addAttribute("searchVO", searchVO );		
	
		
	for (int i=0; i<li.size();i++) {
		System.out.println(li.get(i).getBoDelYn()+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
		model.addAttribute("qnaList", li);
		
		return "qna/qnaList";
	}
	
	@RequestMapping(value = "/qnaView.wow", params = "boNo")
	public ModelAndView qnaView(@RequestParam("boNo") int boNo) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			QnaVO qna = qnaService.getQna(boNo);
			qnaService.increaseHit(boNo); // 조회수 증가
			mav.addObject("qna", qna);
			mav.setViewName("qna/qnaView");			
		} catch (BizNotFoundException e) {
			ResultMessageVO messageVO = 
					new ResultMessageVO()
		          .setResult(false)
		          .setTitle("글이 존재하지 않습니다.")
		          .setMessage("해당 글이 삭제되었거나 존재하지 않습니다.");
			mav.addObject("messageVO", messageVO);
			mav.setViewName("common/message");
		}
		return mav;	
	}
	@RequestMapping("/qnaEdit.wow")
	public String qnaEdit(int boNo, Model model) throws Exception {
	  try{
	  	QnaVO qna = qnaService.getQna(boNo);
	  	
	  	model.addAttribute("qna", qna);
	  	return "qna/qnaEdit";
	  	
	  }catch(BizNotFoundException e){
	  	ResultMessageVO messageVO = 
					new ResultMessageVO()
		          .setResult(false)
		          .setTitle("글이 존재하지 않습니다.")
		          .setMessage("해당 글이 삭제되었거나 존재하지 않습니다.");
			
	  	model.addAttribute("messageVO", messageVO);
			return "common/message";
	  }
	}
	
	@RequestMapping(path = "/qnaModify.wow", method = RequestMethod.POST )
	public String qnaModify( @Validated(value = {Default.class, ModifyType.class})
	                          @ModelAttribute("qna") QnaVO qna
													, Errors error 
			                    , Model model	) throws Exception {
		if(error.hasErrors()) {			
			logger.info("사용자입력검증 실패");
			return "qna/qnaEdit";
		}
		
		ResultMessageVO messageVO = new ResultMessageVO();		
		try {
			qnaService.modifyQna(qna);
			messageVO.setResult(true)
								.setTitle("수정 완료")
								.setMessage("정상적으로 수정되었습니다.")
								.setUrl("/qna/qnaList.wow")
								.setUrlTitle("게시판 목록");			
		} catch (BizNotFoundException e) {
			messageVO.setResult(false)
							.setTitle("글이 존재하지 않습니다.")
							.setMessage("해당 글이 삭제되었거나, 존재하지 않는 글입니다.")
							.setUrl("/qna/qnaList.wow")
							.setUrlTitle("게시판 목록");
		} catch (BizPasswordNotMatchedException e) {			
			// 다시 수정화면을 뷰로 한다.
			return "qna/qnaEdit";
		}
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}
	
	@RequestMapping("/qnaForm.wow")
	public String qnaForm(@ModelAttribute("qna") QnaVO qna
			,@RequestParam(required = false,value = "boGroupNo") int boGroupNo
			,@RequestParam(required = false,value = "boGroupDepth") int boGroupDepth
			,Model model)throws Exception {
		if(boGroupDepth>=0 && boGroupNo>=0) {
			//댓글쓴거
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			qna.setBoGroupDepth(boGroupDepth);
			qna.setBoGroupNo(boGroupNo);
		}else {
			//새글쓰기  암것도 안함
			
		}
	  
		
		
		model.addAttribute("qna",qna);
		
		return "qna/qnaForm";
	}
	
	
	@RequestMapping("/qnaRegist.wow")
	public String qnaRegist( @Validated(value = {Default.class, RegistType.class})
	                           @ModelAttribute("qna") QnaVO qna
			                    , Errors error
			                    , Model model
			                    , HttpServletRequest req)throws Exception {
		// 일반적인 검증 이외에 별도의 로직이 필요한 에러
		// 예시 : 카테고리 , 내용 둘 중 하나는 필수 
//		if(StringUtils.isBlank(free.getBoCategory()) 
//				  && StringUtils.isBlank(free.getBoContent()) ) {
//			error.reject("error.dupcheck", "게시판 분류, 내용 중 하나는 꼭 입력해 주세요");
//		}
		
		if(error.hasErrors()) {
			return "qna/qnaForm";
		}
				
		qna.setBoIp(req.getRemoteAddr());

		if(qna.getBoGroupDepth()==-1&&qna.getBoGroupNo()==-1) {
			//새글쓰기
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			qnaService.registQna(qna);
		}else {
			//댓글쓰기
			qnaService.registQnaReply(qna);
		}
		
		
		
		return "redirect:/qna/qnaList.wow";
	}
	
	
	
	
	
	@RequestMapping("/qnaDelete.wow")
	public String qnaDelete(@ModelAttribute("qna")QnaVO qna,Model model)throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		
			try{
				qnaService.removeQna(qna);
				messageVO.setResult(true)
				.setTitle("게시물 삭제 완료")
				.setMessage("정상적으로 식제되었습니다.")
				.setUrl("/qna/qnaList.wow")
				.setUrlTitle("게시판 목록");
			}catch(BizNotFoundException e){
				messageVO.setResult(false)
				.setTitle("해당글이 존재하지 않습니다.")
				.setMessage("해당글이 삭제되었거나 존재하지 않는 글입니다.")
				.setUrl("/qna/qnaList.wow")
				.setUrlTitle("게시판 목록");
			}catch(BizPasswordNotMatchedException e){
				// 다시 수정화면을 뷰로 한다.
				return "qna/qnaEdit";
			}
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}
}
