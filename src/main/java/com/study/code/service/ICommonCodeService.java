package com.study.code.service;

import java.util.List;

import com.study.code.vo.CodeVO;

public interface ICommonCodeService {
	
	/**
	 * <b>공통코드에 조회목록을 리턴한다.</b>
	 *  
	 * @param parentCode
	 * @return 코드목록 List<CodeVO>
	 */
	List<CodeVO> getCodeListByParent(String parentCode) ;
	
}
