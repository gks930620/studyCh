package com.aop.step1;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.study.exception.BizNotFoundException;
import com.study.member.dao.IMemberDao;
import com.study.member.vo.MemberSearchVO;
import com.study.member.vo.MemberVO;

@Service("memberService")
public class MemberService{

	@Inject
	private IMemberDao memberDao;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	

	public List<MemberVO> getMemberList(MemberSearchVO searchVO) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n-----------------------------------------");
		sb.append("\n MemberService : getMemberList ");
		sb.append("\n args : " + ToStringBuilder.reflectionToString(searchVO));
		sb.append("\n-----------------------------------------");
		logger.debug(sb.toString());
		
		int cnt = memberDao.getMemberCount(searchVO);
		searchVO.setTotalRowCount(cnt);
		searchVO.setting();
		List<MemberVO> list = memberDao.getMemberList(searchVO);
		
		return list;
	}	
	
	
	public MemberVO getMember(String memId) throws BizNotFoundException {
		StringBuilder sb = new StringBuilder();
		sb.append("\n-----------------------------------------");
		sb.append("\n MemberService : getMember ");
		sb.append("\n args : " + ToStringBuilder.reflectionToString(memId));
		sb.append("\n-----------------------------------------");
		logger.debug(sb.toString());
		
		MemberVO vo = memberDao.getMember(memId);
		if (vo == null) {
			throw new BizNotFoundException("[" + memId + "] 조회 실패 ");
		}
		
		return vo;
	}


	
}
