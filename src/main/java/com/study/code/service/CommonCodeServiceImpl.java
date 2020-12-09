package com.study.code.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.study.code.dao.ICommonCodeDao;
import com.study.code.vo.CodeVO;

@Service("babo")
public class CommonCodeServiceImpl implements ICommonCodeService {

//	@Inject
//	private SqlSessionFactory sessionFactory;//  = MyBatisSessionFactory.getSqlSessionFactory();
	
	//private ICommonCodeDao codeDao = new CommonCodeDaoOracle();
	@Inject
	private ICommonCodeDao codeDao;
	
	@Override
	public List<CodeVO> getCodeListByParent(String parentCode) {
			
			return codeDao.getCodeListByParent(parentCode);
			
		
	}

}
