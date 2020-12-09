package com.study.member.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.study.exception.BizDuplicatedKeyException;
import com.study.exception.BizNotEffectedException;
import com.study.exception.BizNotFoundException;
import com.study.exception.DaoDuplicatedKeyException;
import com.study.member.dao.IMemberDao;
import com.study.member.vo.MemberSearchVO;
import com.study.member.vo.MemberVO;
import com.study.util.MyBatisSessionFactory;


@Service
public class MemberServiceImpl implements IMemberService {
	
	@Inject
	private IMemberDao memberDao; // = new MemberDaoOracle();

	
	@Override
	public List<MemberVO> getMemberList(MemberSearchVO searchVO) {
		
			// PagingVO 값 설정
			System.out.println("--------------------------------------");
			searchVO.setTotalRowCount( memberDao.getMemberCount(searchVO)); // 행 총 건수 설정
			searchVO.setting(); //
			System.out.println(searchVO); // console로 확인
			
			List<MemberVO> list = memberDao.getMemberList(searchVO); // 파라미터 값 변경
			return list;
		
	}

	@Override
	public MemberVO getMember(String memId) throws BizNotFoundException {
		
			MemberVO member = memberDao.getMember(memId);
			if(member == null) {
				throw new BizNotFoundException("[" + memId + "] 회원조회를 실패했습니다.");
			}
			return member;
		
	}

	@Override
	public void registMember(MemberVO member) throws BizDuplicatedKeyException {
//		MemberVO m = memberDao.getMember(member.getMemId());
//		if(m != null) {
//			throw new BizDuplicatedKeyException("....");
//		}

			memberDao.insertMember(member);
		
	}

	@Override
	public void modifyMember(MemberVO member) throws BizNotEffectedException, BizNotFoundException {
	
			MemberVO vo = memberDao.getMember(member.getMemId());
			if(vo == null) {
				throw new BizNotFoundException("[" + member.getMemId() + "]이 존재하지 않습니다.");
			}
			
			int cnt = memberDao.updateMember(member);
			if(cnt < 1) { // 건 수가 없을 경우( 에러아님 )
				throw new BizNotEffectedException("[" + member.getMemId() + "]의 회원정보가 변경되지 않았습니다.");
			}
		
	}

	@Override
	public void removeMember(MemberVO member) throws BizNotEffectedException, BizNotFoundException {
		
			
			MemberVO vo = memberDao.getMember(member.getMemId());
			if(vo == null) {
				throw new BizNotFoundException("[" + member.getMemId() + "]이 존재하지 않습니다.");
			}
			
			int cnt = memberDao.deleteMember(member);
			if(cnt < 1) { // 건 수가 없을 경우( 에러아님 )
				throw new BizNotEffectedException("[" + member.getMemId() + "]의 회원탈퇴가 되지 않았습니다.");
			}
			
	}

}
