package com.study.member.vo;

import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class MemberVO {
	
	@NotBlank(message = "아이디는 필수입력값입니다.")
	@Size(min = 4, max = 12, message = "아이디는 4~12글자로 하세요..")
	private String memId;         /* 아이디 */
	
	@NotBlank(message = "비밀보노는 필수입력값입니다.")
	private String memPass;       /* 비빌번호 */
	
	@NotBlank(message = "당신 이름은 필수입력값입니다.")
	private String memName;       /* 회원명 */
	
	@NotBlank(message = "생년월일은 필수입력값입니다.")
	private String memBir;        /* 생일 */

	@NotBlank(message = "우편보노는 필수입력값입니다.")
	private String memZip;        /* 우편번호 */
	
	@NotBlank(message = "주소는 필수입력값입니다.")
	private String memAdd1;       /* 기본주소 */
	
	@NotBlank(message = "상세주소는 필수입력값입니다.")
	private String memAdd2;       /* 상세주소 */
	
	private String memHp;         /* 핸드폰 */
	
	@NotBlank(message = "이메일주소는 필수입력값입니다.")
	@Email(message = "이메일주소는 필수입력값입니다.")
	private String memMail;       /* 메일주소 */
	
	private String memJob;        /* 직업 코드 */
	private String memLike;       /* 취미 코드 */
	private int memMileage;       /* 마일리지 */
	private String memDelYn;      /* 탈퇴 여부 */
	
	// 추가적인 맴버필드 
	private String memJobNm;        /* 직업 코드 명 */
	private String memLikeNm;       /* 취미 코드 명 */
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
		
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {		
		this.memId = memId;
	}
	public String getMemPass() {
		return memPass;
	}
	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemBir() {
		return memBir;
	}
	public void setMemBir(String memBir) {
		this.memBir = memBir;
	}
	public String getMemZip() {
		return memZip;
	}
	public void setMemZip(String memZip) {
		this.memZip = memZip;
	}
	public String getMemAdd1() {
		return memAdd1;
	}
	public void setMemAdd1(String memAdd1) {
		this.memAdd1 = memAdd1;
	}
	public String getMemAdd2() {
		return memAdd2;
	}
	public void setMemAdd2(String memAdd2) {
		this.memAdd2 = memAdd2;
	}
	public String getMemHp() {
		return memHp;
	}
	public void setMemHp(String memHp) {
		this.memHp = memHp;
	}
	public String getMemMail() {
		return memMail;
	}
	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}
	public String getMemJob() {
		return memJob;
	}
	public void setMemJob(String memJob) {
		this.memJob = memJob;
	}
	public String getMemLike() {
		return memLike;
	}
	public void setMemLike(String memLike) {
		this.memLike = memLike;
	}
	public int getMemMileage() {
		return memMileage;
	}
	public void setMemMileage(int memMileage) {
		this.memMileage = memMileage;
	}
	public String getMemDelYn() {
		return memDelYn;
	}
	public void setMemDelYn(String memDelYn) {
		this.memDelYn = memDelYn;
	}

	public String getMemJobNm() {
		return memJobNm;
	}

	public void setMemJobNm(String memJobNm) {
		this.memJobNm = memJobNm;
	}

	public String getMemLikeNm() {
		return memLikeNm;
	}

	public void setMemLikeNm(String memLikeNm) {
		this.memLikeNm = memLikeNm;
	}
	
}
