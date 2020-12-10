package com.study.qna.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.qna.vo.QnaSearchVO;
import com.study.qna.vo.QnaVO;


@Mapper
public interface IQnaDao {

	int getQnaCount(QnaSearchVO searchVO);

	List<QnaVO> getQnaList(QnaSearchVO searchVO);
	

	

	
  
}









