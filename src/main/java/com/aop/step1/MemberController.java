package com.aop.step1;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.study.member.vo.MemberSearchVO;
import com.study.member.vo.MemberVO;

@Controller("memberController")
public class MemberController {

	@Inject
	private MemberService memberService;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
		
	public List<MemberVO> getMemberList(MemberSearchVO searchVO) throws Exception {
		long startTime = System.currentTimeMillis();		
		try {
			List<MemberVO> result = memberService.getMemberList(searchVO);
			
			// 서비스의 결과객체 확인
			StringBuilder sb = new StringBuilder();
			logger.debug("-----------------------------------------------");
			sb.append("\n MemberController : getMemberList ");
			sb.append("\n Return list.count " + result.size() );
			logger.debug(sb.toString());		
			for(MemberVO vo : result) {
				logger.debug(ToStringBuilder.reflectionToString(vo, ToStringStyle.JSON_STYLE));
			}
			logger.debug("-----------------------------------------------");		
			return result;
		}finally {
		  // 서비스의 수행시간 체크 
			long duration = System.currentTimeMillis() - startTime;		
			logger.info("{}.{} : 수행시간 = {}", getClass().getSimpleName(), "getMemberList", duration);
		}
	}
	
	public MemberVO getMember(String memId) throws Exception {
		long startTime = System.currentTimeMillis();
		
		MemberVO member = memberService.getMember(memId);
		
		try {
			// 서비스의 결과객체 확인
			StringBuilder sb = new StringBuilder();
			logger.debug("-----------------------------------------------");
			sb.append("\n MemberController : getMember ");
			sb.append("\n Return member=" + ToStringBuilder.reflectionToString(member, ToStringStyle.MULTI_LINE_STYLE));
			logger.debug(sb.toString());
			logger.debug("-----------------------------------------------");
			return member;
		}catch (Exception e) {
		  // 예외에 대한 로그 기록 
			StringBuilder sb = new StringBuilder();
			logger.error("-----------------------------------------------");
			sb.append("\n MemberController : getMember ");
			sb.append("\n Exception Raise : " + e.getMessage() );
			logger.error(sb.toString(), e);  // 예외 발생객체(e)를 꼭 넘기자 
			logger.error("-----------------------------------------------");
			throw e;  // 호출객체에게 예외 전파
		} finally {
			// 서비스의 수행시간 체크 
			long duration = System.currentTimeMillis() - startTime;		
			logger.info("{}.{} : 수행시간 = {}", getClass().getSimpleName(), "getMember", duration);
		}
	}
	
}









