package com.study.free.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import com.study.exception.BizNotFoundException;
import com.study.exception.BizPasswordNotMatchedException;
import com.study.free.dao.IFreeBoardDao;
import com.study.free.vo.FreeBoardSearchVO;
import com.study.free.vo.FreeBoardVO;

@Service
public class FreeBoardServiceImpl implements IFreeBoardService {
	
	@Inject
	private IFreeBoardDao freeDao;
	
	
	@Override
	public List<FreeBoardVO> getBoardList(FreeBoardSearchVO searchVO) {
			System.out.println("-------------------------------------");
			searchVO.setTotalRowCount( freeDao.getBoardCount(searchVO) );
			searchVO.setting();
			System.out.println(searchVO);	
			List<FreeBoardVO> list = freeDao.getBoardList(searchVO);
			return list;
	}

	@Override
	public FreeBoardVO getBoard(int boNo) throws BizNotFoundException {
			 FreeBoardVO vo = freeDao.getBoard(boNo);			
       // FreeBoardVO vo = session.selectOne("com.study.free.dao.IFreeBoardDao.getBoard", boNo);
			 
			if(vo == null) {
				throw new BizNotFoundException("[" + boNo + "]글이 존재하지 않습니다.");
			}
			return vo;
	}

	@Override
	public void registBoard(FreeBoardVO board) {
			freeDao.insertBoard(board);
	}

	@Override
	public void modifyBoard(FreeBoardVO board) throws BizNotFoundException, BizPasswordNotMatchedException {
			// 조회해서 없으면  
			// 조회한(DB) 패스워드 , 사용자가 입력한 패스워드 비교 
			FreeBoardVO  vo = freeDao.getBoard(board.getBoNo());
			if(vo == null) {
				throw new BizNotFoundException("[" + board.getBoNo() + "]글이 존재하지 않습니다.");
			}
			if( !vo.getBoPass().equals(board.getBoPass()) ) {
				throw new BizPasswordNotMatchedException();
			}		
			
			freeDao.updateBoard(board);
	}

	@Override
	public void removeBoard(FreeBoardVO board) throws BizNotFoundException, BizPasswordNotMatchedException{
			// 조회해서 없으면  
			// 조회한(DB) 패스워드 , 사용자가 입력한 패스워드 비교 
			FreeBoardVO  vo = freeDao.getBoard(board.getBoNo());
			if(vo == null) {
				throw new BizNotFoundException("[" + board.getBoNo() + "]글이 존재하지 않습니다.");
			}
			if( !vo.getBoPass().equals(board.getBoPass()) ) {
				throw new BizPasswordNotMatchedException();
			}		
			freeDao.deleteBoard(board);			
	}

	@Override
	public void increaseHit(int boNo) {
			freeDao.increaseHit(boNo);
	}

}
