package com.study.qna.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import com.study.exception.BizNotFoundException;
import com.study.exception.BizPasswordNotMatchedException;
import com.study.free.dao.IFreeBoardDao;
import com.study.free.vo.FreeBoardSearchVO;
import com.study.free.vo.FreeBoardVO;
import com.study.member.vo.MemberVO;

import com.study.qna.dao.IQnaDao;

import com.study.qna.vo.QnaSearchVO;
import com.study.qna.vo.QnaVO;

@Service
public class QnaServiceImpl implements IQnaService {
	
	@Inject
	private IQnaDao qnaDao;

	@Override
	public List<QnaVO> getQnaList(QnaSearchVO searchVO) {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		searchVO.setTotalRowCount( qnaDao.getQnaCount(searchVO) );
		System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		searchVO.setting();
		System.out.println(searchVO);	
		List<QnaVO> list = qnaDao.getQnaList(searchVO);
		return list;
		
		
	}


	
	


}
