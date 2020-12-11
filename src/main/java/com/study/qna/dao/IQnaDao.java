package com.study.qna.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.free.vo.FreeBoardSearchVO;
import com.study.free.vo.FreeBoardVO;
import com.study.qna.vo.QnaSearchVO;
import com.study.qna.vo.QnaVO;


/**
 * @author saam
 *
 */
@Mapper
public interface IQnaDao {
	
	int getQnaCount(QnaSearchVO searchVO);
	
	
	
	public List<QnaVO> getQnaList(QnaSearchVO searchVO) ;
	
	/**
	 * <b>글번호에 해당하는 게시물 반환</b>
	 * @param conn
	 * @param boNo
	 * @return FreeBoardVO
	 */
  public QnaVO getQna( int boNo);
  
  /**
   * <b>게시물 등록</b>
   * @param conn
   * @param board
   * @return  영향받은 행수 
   */
  public int insertQna( QnaVO qna);
  public int insertQnaReply( QnaVO qna);
  
  /**
   * <b>해당 게시물 변경</b> 
   * @param conn
   * @param board
   * @return  영향받은 행수 
   */
  public int updateQna(QnaVO qna);
  
  /**
   * <b>해당 게시물의 삭제여부를 "Y" 로 변경 </b> 
   * @param conn
   * @param board
   * @return 영향받은 행수 
   */
  public int deleteQna(QnaVO qna);
  
  /**
   * <b>해당 게시물의 조회수 1 증가</b> 
   * @param conn
   * @param boNo
   * @return 영향받은 행수
   */
  public int increaseHit(int boNo);

	
  
}









