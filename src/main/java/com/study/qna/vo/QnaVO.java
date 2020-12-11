package com.study.qna.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.study.common.valid.ModifyType;
import com.study.common.valid.RegistType;

public class QnaVO {
	@NotNull(message = "글번호는 필수입니다." , groups = ModifyType.class)
	@Min(value = 1, message = "글번호가 비어있습니다.", groups = ModifyType.class)
	private int boNo;             /* 글 번호 */
	
	@NotBlank(message = "제목은 필수입니다." , groups = { ModifyType.class, RegistType.class})
	@Size(min = 3, max = 100, message = "제목은 3글자 이상 100글자 이하입니다."
	        , groups = { ModifyType.class, RegistType.class})
	private String boTitle;       /* 글 제목 */
	
	// @NotBlank(message = "분류는 필수입니다.")
	private String boCategory;    /* 글 분류 코드 */
	
	@NotBlank(message = "작성자는 필수입니다.")
	@Pattern(regexp = "[가-힣]{2,}" , message = "작성자는 한글로 2글자 이상입니다.")
	private String boWriter;      /* 작성자명 */
	
	// \w : [a-zA-Z0-9_], \W : 일반 문자가 아닌것   
	@NotBlank(message = "비밀번호는 필수입니다.")
	@Pattern(regexp = "[\\w!-/]{4,16}" , message = "비밀번호는 알파벳,숫자,특수기호로 4글자 이상 16글자 이하입니다.")
	private String boPass;        /* 비밀번호 */
	
	private String boContent;     /* 글 내용 */
	
	private String boIp;          /* 등록자 IP */
	private int boHit;            /* 조회수 */
	private String boRegDate;     /* 등록 일자 */
	private String boModDate;     /* 수정 일자 */
	private String boDelYn;       /* 삭제 여부 */
	private int boGroupNo;					//깊이0의 글과 1:1대칭되는 그룹번호
	private int boGroupDepth;       //0은 원글,1은 답글,2는 답글의 답글 
	
	//-------------------
	private String boCategoryNm;    /* 글 분류 명 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	public int getBoNo() {
		return boNo;
	}
	public void setBoNo(int boNo) {
		this.boNo = boNo;
	}
	public String getBoTitle() {
		return boTitle;
	}
	public void setBoTitle(String boTitle) {
		this.boTitle = boTitle;
	}
	public String getBoCategory() {
		return boCategory;
	}
	public void setBoCategory(String boCategory) {
		this.boCategory = boCategory;
	}
	public String getBoWriter() {
		return boWriter;
	}
	public void setBoWriter(String boWriter) {
		this.boWriter = boWriter;
	}
	public String getBoPass() {
		return boPass;
	}
	public void setBoPass(String boPass) {
		this.boPass = boPass;
	}
	public String getBoContent() {
		return boContent;
	}
	public void setBoContent(String boContent) {
		this.boContent = boContent;
	}
	public String getBoIp() {
		return boIp;
	}
	public void setBoIp(String boIp) {
		this.boIp = boIp;
	}
	public int getBoHit() {
		return boHit;
	}
	public void setBoHit(int boHit) {
		this.boHit = boHit;
	}
	public String getBoRegDate() {
		return boRegDate;
	}
	public void setBoRegDate(String boRegDate) {
		this.boRegDate = boRegDate;
	}
	public String getBoModDate() {
		return boModDate;
	}
	public void setBoModDate(String boModDate) {
		this.boModDate = boModDate;
	}
	public String getBoDelYn() {
		return boDelYn;
	}
	public void setBoDelYn(String boDelYn) {
		this.boDelYn = boDelYn;
	}
	public int getBoGroupNo() {
		return boGroupNo;
	}
	public void setBoGroupNo(int boGroupNo) {
		this.boGroupNo = boGroupNo;
	}
	public int getBoGroupDepth() {
		return boGroupDepth;
	}
	public void setBoGroupDepth(int boGroupDepth) {
		this.boGroupDepth = boGroupDepth;
	}
	public String getBoCategoryNm() {
		return boCategoryNm;
	}
	public void setBoCategoryNm(String boCategoryNm) {
		this.boCategoryNm = boCategoryNm;
	}

}
