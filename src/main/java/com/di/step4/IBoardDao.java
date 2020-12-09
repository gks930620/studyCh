package com.di.step4;

public interface IBoardDao {

	// 수업을 위한 단순 처리이므로 리턴은 void 로 합니다.
	
	public abstract void getConnectionInfo();
	
	public abstract void getBoardList();
	
	public abstract void getBoard(int boNo);

}