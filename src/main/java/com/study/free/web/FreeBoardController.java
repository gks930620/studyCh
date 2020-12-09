package com.study.free.web;

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
import com.study.free.service.IFreeBoardService;
import com.study.free.vo.FreeBoardSearchVO;
import com.study.free.vo.FreeBoardVO;

@Controller
// @RequestMapping("/free")
public class FreeBoardController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
		
	@Inject
	private ICommonCodeService codeService;
	
	@Inject
	private IFreeBoardService freeBoardService;
		
	// @ModelAttribute 는 요청 메시드 진입전에 
	// 먼저 동작하여 모델에 저장해줍니다.
	// 해당 이름의 모델이 이미 존재하는 경우는 수행을 하지 않습니다. 
	@ModelAttribute("categoryList")
	public List<CodeVO> getCategoryList() {
		logger.debug("기백아빠. 고깃집 파이팅~~~");
		List<CodeVO> categoryList = codeService.getCodeListByParent("BC00");		
		return categoryList; 
	}
	
	@RequestMapping("/free/freeList.wow")
	public String freeList(@ModelAttribute("searchVO") FreeBoardSearchVO searchVO
			           , Model model) throws Exception {
		// 커맨드객체(VO)는 자동으로 모델에 저장 
		//  이름은 클래스명의 첫글자 소문자로 해서 "freeBoardSearchVO"  
		//  @ModelAttribute 를 사용해서 이름을 변경 할 수 있다.		
			
		List<FreeBoardVO> li = freeBoardService.getBoardList(searchVO);
		
		// model.addAttribute("searchVO", searchVO );		
		model.addAttribute("freeList", li);
		
		return "free/freeList";
	}
	
	@RequestMapping(value = "/free/freeView.wow", params = "boNo")
	public ModelAndView freeView(@RequestParam("boNo") int boNo) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			FreeBoardVO free = freeBoardService.getBoard(boNo);
			freeBoardService.increaseHit(boNo); // 조회수 증가
			mav.addObject("free", free);
			mav.setViewName("free/freeView");			
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
	@RequestMapping("/free/freeEdit.wow")
	public String freeEdit(int boNo, Model model) throws Exception {
	  try{
	  	FreeBoardVO free = freeBoardService.getBoard(boNo);
	  	
	  	model.addAttribute("free", free);
	  	return "free/freeEdit";
	  	
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
	
	@RequestMapping(path = "/free/freeModify.wow", method = RequestMethod.POST )
	public String freeModify( @Validated(value = {Default.class, ModifyType.class})
	                          @ModelAttribute("free") FreeBoardVO free
													, Errors error 
			                    , Model model	) throws Exception {
		if(error.hasErrors()) {			
			logger.info("사용자입력검증 실패");
			return "free/freeEdit";
		}
		
		ResultMessageVO messageVO = new ResultMessageVO();		
		try {
			freeBoardService.modifyBoard(free);
			messageVO.setResult(true)
								.setTitle("수정 완료")
								.setMessage("정상적으로 수정되었습니다.")
								.setUrl("/free/freeList.wow")
								.setUrlTitle("게시판 목록");			
		} catch (BizNotFoundException e) {
			messageVO.setResult(false)
							.setTitle("글이 존재하지 않습니다.")
							.setMessage("해당 글이 삭제되었거나, 존재하지 않는 글입니다.")
							.setUrl("/free/freeList.wow")
							.setUrlTitle("게시판 목록");
		} catch (BizPasswordNotMatchedException e) {			
			// 다시 수정화면을 뷰로 한다.
			return "free/freeEdit";
		}
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}
	
	@RequestMapping("/free/freeForm.wow")
	public String freeForm(@ModelAttribute("free") FreeBoardVO free,  Model model)throws Exception {
	  	
		return "free/freeForm";
	}
	
	
	@RequestMapping("/free/freeRegist.wow")
	public String freeRegist( @Validated(value = {Default.class, RegistType.class})
	                           @ModelAttribute("free") FreeBoardVO free
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
			return "free/freeForm";
		}
				
		free.setBoIp(req.getRemoteAddr());

		freeBoardService.registBoard(free);
		
		return "redirect:/free/freeView.wow?boNo=" + free.getBoNo();
	}
	
	
	@RequestMapping("/free/freeDelete.wow")
	public String freeDelete(@ModelAttribute("free") FreeBoardVO free,Model model)throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		
			try{
				freeBoardService.removeBoard(free);
				messageVO.setResult(true)
				.setTitle("게시물 삭제 완료")
				.setMessage("정상적으로 식제되었습니다.")
				.setUrl("/free/freeList.wow")
				.setUrlTitle("게시판 목록");
			}catch(BizNotFoundException e){
				messageVO.setResult(false)
				.setTitle("해당글이 존재하지 않습니다.")
				.setMessage("해당글이 삭제되었거나 존재하지 않는 글입니다.")
				.setUrl("/free/freeList.wow")
				.setUrlTitle("게시판 목록");
			}catch(BizPasswordNotMatchedException e){
				// 다시 수정화면을 뷰로 한다.
				return "free/freeEdit";
			}
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}
	
}

