package com.aop.step2;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.study.member.vo.MemberSearchVO;
import com.study.member.vo.MemberVO;

public class MemberControllerTest {

	/**
	 * AOP 가 적용안된 서비스 테스트 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// 스프링 설정을 읽어서 해당 빈을 받아서 실행 
		AbstractApplicationContext context 
		  = new GenericXmlApplicationContext("spring/aop_step2.xml");
		
		MemberController controller =context.getBean("memberController", MemberController.class);
		
		MemberVO member = controller.getMember("b001");
		System.out.println(member.getMemName());
		
		MemberSearchVO searchVO = new MemberSearchVO();
		searchVO.setRowSizePerPage(5);
		searchVO.setCurPage(1);
		List<MemberVO> members = controller.getMemberList(searchVO);
		
		int cnt = 1;
		for(MemberVO vo : members) {
			System.out.println(cnt++ + ":" + vo.getMemName() );
		}
		     
		context.close();
	}
	
}
