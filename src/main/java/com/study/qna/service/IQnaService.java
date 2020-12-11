package com.study.qna.service;

import java.util.List;

import com.study.exception.BizNotFoundException;
import com.study.exception.BizPasswordNotMatchedException;
import com.study.free.vo.FreeBoardSearchVO;
import com.study.free.vo.FreeBoardVO;
import com.study.member.vo.MemberVO;
import com.study.qna.vo.QnaSearchVO;
import com.study.qna.vo.QnaVO;


public interface IQnaService {


	/**
	 * <b>자유게시판 목록 반환</b>
	 * @param searchVO TODO
	 * @return List &lt;FreeBoardVO&gt;
	 */
  public List<QnaVO> getQnaList(QnaSearchVO searchVO);
  
  
	/**
	 * <b>글번호에 해당하는 게시물 반환</b>
	 * <p style="color:red;">글번호가 존재하지 않으면 BizNotFoundException 발생 </p><br>
	 * @param boNo
	 * @return FreeBoardVO
	 */
  public QnaVO getQna(int boNo) throws BizNotFoundException;
  
  
  /**
   * <b>게시물 등록</b> 
   * @param FreeBoardVO
   *  
   */
  public void registQna(QnaVO qna);
  public void registQnaReply(QnaVO qna);
  
  /**
   * <b>게시물 변경</b> 
   * <p style="color:red;">글번호가 존재하지 않으면 BizNotFoundException 발생 </p><br> 
   * <p style="color:red;">패스워드가 틀리면  BizPasswordNotMatchedException 발생 </p><br>
   * @param board
   */
  public void modifyQna(QnaVO qna) throws BizNotFoundException, BizPasswordNotMatchedException;
  
  
  /**
   * <b>해당 게시물의 삭제여부를 "Y" 로 변경 </b> 
   * <p style="color:red;">글번호가 존재하지 않으면 BizNotFoundException 발생 </p><br> 
   * <p style="color:red;">패스워드가 틀리면  BizPasswordNotMatchedException 발생 </p><br>
   * @param board
   */
  public void removeQna(QnaVO qna) throws BizNotFoundException, BizPasswordNotMatchedException;
  
  
  /**
   * <b>해당 게시물의 조회수 1 증가</b> 
   * @param conn
   * @param boNo
   * @return 영향받은 행수
   */
  public void increaseHit(int boNo);   

  

}
