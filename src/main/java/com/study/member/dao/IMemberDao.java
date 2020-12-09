package com.study.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.member.vo.MemberSearchVO;
import com.study.member.vo.MemberVO;

@Mapper
public interface IMemberDao {

	public int getMemberCount(MemberSearchVO searchVO);
	
	public abstract List<MemberVO> getMemberList(MemberSearchVO searchVO);
	
	public MemberVO getMember(String memId);

	int deleteMember(MemberVO member);

	int updateMember(MemberVO member);

	int insertMember(MemberVO member);

}
