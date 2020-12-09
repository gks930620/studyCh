package com.study.member.service;

import java.util.List;

import com.study.exception.BizDuplicatedKeyException;
import com.study.exception.BizNotEffectedException;
import com.study.exception.BizNotFoundException;
import com.study.member.vo.MemberSearchVO;
import com.study.member.vo.MemberVO;

/**
 * 회원정보를 관리하는 서비스 
 * @author 연세바보 
 * @since 2020.11.06
 */
public interface IMemberService {

	/**
	 * <b>회원목록을 조회하여 리턴<b><br>
	 * 검색조건 결과에 맞는 회원목록리스트 반환 <br>
	 * @param searchVO TODO
	 * 
	 * @return List<MemberVO>
	 */
	public List<MemberVO> getMemberList(MemberSearchVO searchVO);
	
	/**
	 * <b>회원조회</b><br>
	 * 회원아이디에 해당하는 회원을 리턴한다.<br>
	 * <b style="color:red">회원이 존재하지 않을때 BizNotFoundException이 발생</b>한다.
	 * @param memId
	 * @return MemberVO
	 * @throws BizNotFoundException
	 */
	public MemberVO getMember(String memId) throws BizNotFoundException ;
	
	/**
	 * <b>회원정보를 등록한다.</b><br>
	 * <b style="color:red">등록하고자 하는 아이디가 존재하는 경우 BizDuplicatedKeyException발생</b>한다.
	 * @param member
	 * @throws BizDuplicatedKeyException
	 */
	public void registMember(MemberVO member) throws BizDuplicatedKeyException ;
	
	/**
	 * <b>회원정보를 변경한다.</b><br>
	 * <b style="color:red">변경된 정보가 없는 경우 BizNotEffectedException발생</b>한다.
	 * @param member
	 * @throws BizNotEffectedException
	 * @throws BizNotFoundException TODO
	 */
	public void modifyMember(MemberVO member) throws BizNotEffectedException, BizNotFoundException;
	
	/**
	 * <b>회원을 탈퇴시킨다.</b><br>
	 * 회원의 정보중 <b>탈퇴여부를 'Y'로 설정</b>한다.
	 * <b style="color:red">변경된 정보가 없는 경우 BizNotEffectedException발생</b>한다.
	 * @param member
	 * @throws BizNotEffectedException
	 * @throws BizNotFoundException TODO
	 */
	public void removeMember(MemberVO member) throws BizNotEffectedException, BizNotFoundException;
	
}


