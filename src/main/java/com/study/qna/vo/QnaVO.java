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

	@NotNull(message = "글번호는 필수입니다.", groups = ModifyType.class)
	@Min(value = 1, message = "글번호가 비어있습니다.", groups = ModifyType.class)
	private int boNo; /* 글 번호 */
	@NotBlank(message = "작성자는 필수입니다.")
	@Pattern(regexp = "[가-힣]{2,}", message = "작성자는 한글로 2글자 이상입니다.")
	private String boWriter; /* 작성자명 */
	private String boContent; /* 글 내용 */
	private String boRegDate; /* 등록 일자 */
	private String boGroupNo; /* 같은그룹묶어줘야지. */
	private String boGroupDepth; /* 몇번째 답글인지..0 원글 , 1 원글답변 , 2 원글답변의 답변 , 3원글답변의 답변의 다변 */
	private String boDelYn; /* 삭제 여부 */
	private String boTitle;
	
	public String getBoTitle() {
		return boTitle;
	}

	public void setBoTitle(String boTitle) {
		this.boTitle = boTitle;
	}

	public int getBoNo() {
		return boNo;
	}

	public void setBoNo(int boNo) {
		this.boNo = boNo;
	}

	public String getBoWriter() {
		return boWriter;
	}

	public void setBoWriter(String boWriter) {
		this.boWriter = boWriter;
	}

	public String getBoContent() {
		return boContent;
	}

	public void setBoContent(String boContent) {
		this.boContent = boContent;
	}

	public String getBoRegDate() {
		return boRegDate;
	}

	public void setBoRegDate(String boRegDate) {
		this.boRegDate = boRegDate;
	}

	public String getBoGroupNo() {
		return boGroupNo;
	}

	public void setBoGroupNo(String boGroupNo) {
		this.boGroupNo = boGroupNo;
	}

	public String getBoGroupDepth() {
		return boGroupDepth;
	}

	public void setBoGroupDepth(String boGroupDepth) {
		this.boGroupDepth = boGroupDepth;
	}

	public String getBoDelYn() {
		return boDelYn;
	}

	public void setBoDelYn(String boDelYn) {
		this.boDelYn = boDelYn;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
