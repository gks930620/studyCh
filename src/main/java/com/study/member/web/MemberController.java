package com.study.member.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.study.code.service.CommonCodeServiceImpl;
import com.study.code.service.ICommonCodeService;
import com.study.code.vo.CodeVO;
import com.study.common.valid.ModifyType;
import com.study.common.valid.RegistType;
import com.study.common.vo.ResultMessageVO;
import com.study.exception.BizDuplicatedKeyException;
import com.study.exception.BizNotEffectedException;
import com.study.exception.BizNotFoundException;
import com.study.member.service.IMemberService;
import com.study.member.service.MemberServiceImpl;
import com.study.member.vo.MemberSearchVO;
import com.study.member.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {
	private final Logger logger = LoggerFactory.getLogger(getClass());	
	@Inject
	ICommonCodeService codeService;	
	@Inject 
	IMemberService memberService;
	
	@Inject
  private MailSendService mss;

	
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
	
	@RequestMapping("/memberList.wow")
	public String memberList(@ModelAttribute("searchVO") MemberSearchVO searchVO,Model model)throws Exception {
		
		List<MemberVO> members = memberService.getMemberList(searchVO);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		model.addAttribute("members", members);			
		return "member/memberList";
	}
	@RequestMapping("/memberView.wow")
	public ModelAndView memberView(String memId)throws Exception {
		ModelAndView mav = new ModelAndView();
		try{
			MemberVO member =	memberService.getMember(memId);
			mav.addObject("member", member);
			mav.setViewName("member/memberView");
		}catch(BizNotFoundException e){
			ResultMessageVO messageVO = new ResultMessageVO()
					.setResult(false)
					.setTitle("글이 존재하지 않습니다.")
					.setMessage("해당 글이 삭제되었거나 존재하지 않습니다.");
			mav.addObject("messageVO",messageVO);
			mav.setViewName("common/message");
		}
		return mav;
	}
	@RequestMapping("/memberEdit.wow")
	public String memberEdit(Model model,String memId)throws Exception {
		
		try{
			MemberVO member =	memberService.getMember(memId);
			
			model.addAttribute("member", member);
			return "member/memberEdit";
		}catch(BizNotFoundException e){
			ResultMessageVO messageVO = new ResultMessageVO()
					.setResult(false)
					.setTitle("글이 존재하지 않습니다.")
					.setMessage("해당 글이 삭제되었거나 존재하지 않습니다.");
			model.addAttribute("messageVO",messageVO);
			return "common/message";
		}
	}
	@RequestMapping(path = "/memberModify.wow",method = RequestMethod.POST)
	public String memberModify(@Validated(value = {Default.class, ModifyType.class}) @ModelAttribute("member") MemberVO member
									,Errors error
									,Model model)throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		if (error.hasErrors()) {
			logger.info("사용자입력검증 실패");
			return "member/memberEdit";
		}
		try{
			memberService.modifyMember(member);
			messageVO.setResult(true).setTitle("회원수정 완료")
										 .setMessage("회원수정이 완료 되었습니다.")
										 .setUrl("/member/memberList.wow")
										 .setUrlTitle("회원 목록");
		}catch(BizNotFoundException e){
			messageVO.setResult(false).setTitle("회원수정 실패")
										 .setMessage("해당 회원이 존재 하지 않습니다.")
										 .setUrl("/member/memberList.wow")
										 .setUrlTitle("회원 목록");
		}catch(BizNotEffectedException e){
			messageVO.setResult(false).setTitle("회원수정 실패")
										 .setMessage("회원 정보가 변경되지 않았습니다.")
										 .setUrl("/member/memberList.wow")
										 .setUrlTitle("회원 목록");
		}
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}
	
	
	@RequestMapping("/memberForm.wow")
	public String memberForm(@ModelAttribute("member") MemberVO member
			                     , Model model)throws Exception {
		
		return "member/memberForm";
	}
	
	
	@RequestMapping("/memberRegist")
	public String memberRegist(@Validated(value = {Default.class,RegistType.class,ModifyType.class}) @ModelAttribute("member") MemberVO member
									,Errors error
									,Model model)throws Exception {
		if(error.hasErrors()) {
			return "member/memberForm";
		}
		ResultMessageVO messageVO = new ResultMessageVO();

		try {
			memberService.registMember(member);
			messageVO.setResult(true).setTitle("회원가입 완료").setMessage("회원가입이 완료 되었습니다.").setUrl("/member/memberList.wow")
					.setUrlTitle("회원 목록");
		} catch (BizDuplicatedKeyException e) {
			messageVO.setResult(false).setTitle("아이디 중복 오류").setMessage("해당 아이다가 중복되었습니다. 다른 아이디를 사용해 주세요.")
					.setUrl("/member/memberList.wow").setUrlTitle("회원 목록");
		}
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}
	@RequestMapping("/memberDelete.wow")
	public String freeDelete(@ModelAttribute("member") MemberVO member,Model model)throws Exception {
		ResultMessageVO messageVO = new ResultMessageVO();
		
			try{
				memberService.removeMember(member);
				messageVO.setResult(true)
				.setTitle("회원 삭제 완료")
				.setMessage("정상적으로 식제되었습니다.")
				.setUrl("/member/memberList.wow")
				.setUrlTitle("회원 목록");
			}catch(BizNotFoundException e){
				messageVO.setResult(false)
				.setTitle("해당 회원이 존재하지 않습니다.")
				.setMessage("해당 회원이 삭제되었거나 존재하지 않는 회원입니다.")
				.setUrl("/member/memberList.wow")
				.setUrlTitle("회원 목록");
			}
//			catch(BizPasswordNotMatchedException e){
//				List<CodeVO> jobList = codeService.getCodeListByParent("JB00");
//				List<CodeVO> hobbyList = codeService.getCodeListByParent("HB00");
//				model.addAttribute("jobList", jobList);
//				model.addAttribute("hobbyList", hobbyList);
//				// 다시 수정화면을 뷰로 한다.
//				return "member/memberEdit";
//			}
		model.addAttribute("messageVO", messageVO);
		return "common/message";
	}
	
//email보내는거
	@ResponseBody
	@RequestMapping("/signUp.edu")
	public String signUp(@RequestParam(value = "email") String email,HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 임의의 authKey 생성 & 이메일 발송
		String authKey = mss.sendAuthMail(email,req.getServerName(),req.getServerPort());
		return authKey;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}