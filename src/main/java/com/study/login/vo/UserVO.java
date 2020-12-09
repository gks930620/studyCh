package com.study.login.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

// TODO : 차후에 serializable 구현 
public class UserVO {

	private String userId;
	private String userName;
	private String userPass;
	private String userRole;
	private String userAge;
	
	public String getYsLine() {
		return userAge;
	}
	
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	
	public UserVO() {	
	}
	
	public UserVO(String userId, String userName, String userPass, String userRole) {
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.userRole = userRole;
	}
	
	@Override
	public String toString() {	
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	
}
