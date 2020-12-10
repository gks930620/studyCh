package com.study.qna.service;

import java.util.List;

import com.study.member.vo.MemberVO;
import com.study.qna.vo.QnaSearchVO;
import com.study.qna.vo.QnaVO;


public interface IQnaService {

	List<QnaVO> getQnaList(QnaSearchVO searchVO);
	

  

}
