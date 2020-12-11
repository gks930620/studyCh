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
			System.out.println("-------------------------------------");
			searchVO.setTotalRowCount( qnaDao.getQnaCount(searchVO) );
			searchVO.setting();
			System.out.println(searchVO);	
			
			
			List<QnaVO> list = qnaDao.getQnaList(searchVO);
			
			
			
			return list;
	}

	@Override
	public QnaVO getQna(int boNo) throws BizNotFoundException {
		QnaVO vo = qnaDao.getQna(boNo);			
       // FreeBoardVO vo = session.selectOne("com.study.free.dao.IFreeBoardDao.getBoard", boNo);
			 
			if(vo == null) {
				throw new BizNotFoundException("[" + boNo + "]글이 존재하지 않습니다.");
			}
			return vo;
	}

	@Override
	public void registQna(QnaVO qna) {
			qnaDao.insertQna(qna);
	}
	
	@Override
	public void registQnaReply(QnaVO qna) {
			qnaDao.insertQnaReply(qna);
	}

	@Override
	public void modifyQna(QnaVO qna) throws BizNotFoundException, BizPasswordNotMatchedException {
			// 조회해서 없으면  
			// 조회한(DB) 패스워드 , 사용자가 입력한 패스워드 비교 
		QnaVO  vo = qnaDao.getQna(qna.getBoNo());
			if(vo == null) {
				throw new BizNotFoundException("[" + qna.getBoNo() + "]글이 존재하지 않습니다.");
			}
			if( !vo.getBoPass().equals(qna.getBoPass()) ) {
				throw new BizPasswordNotMatchedException();
			}		
			
			qnaDao.updateQna(qna);
	}

	@Override
	public void removeQna(QnaVO qna) throws BizNotFoundException, BizPasswordNotMatchedException{
			// 조회해서 없으면  
			// 조회한(DB) 패스워드 , 사용자가 입력한 패스워드 비교 
		QnaVO  vo = qnaDao.getQna(qna.getBoNo());
			if(vo == null) {
				throw new BizNotFoundException("[" + qna.getBoNo() + "]글이 존재하지 않습니다.");
			}
			if( !vo.getBoPass().equals(qna.getBoPass()) ) {
				throw new BizPasswordNotMatchedException();
			}		
			qnaDao.deleteQna(qna);			
	}

	@Override
	public void increaseHit(int boNo) {
			qnaDao.increaseHit(boNo);
	}

}
