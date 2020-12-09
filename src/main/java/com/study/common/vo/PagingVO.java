package com.study.common.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


@SuppressWarnings("serial")
public class PagingVO implements Serializable {
	
	private int curPage;          // 현재 페이지 번호
	private int rowSizePerPage;   // 한 페이지당 레코드 수
	private int firstRow ;        // 시작 레크드 번호   
	private int lastRow;          // 마지막 레크드 번호 
	private int totalRowCount ;   // 총 레코드 건수
	private int totalPageCount;   // 총 페이지 건수
	
	private int pageSize;   // 페이지 리스트에서 보여줄 페이지 갯수
	private int firstPage;  // 페이지 리스트에서 시작  페이지 번호 
	private int lastPage;   // 페이지 리스트에서 마지막 페이지 번호 
	
	public static void main(String[] args) {
		PagingVO vo = new PagingVO();
		vo.setTotalRowCount(237);
		vo.setCurPage(22);
		vo.setting();
		System.out.println(vo);
	}
	
	public void setting() {
		if(curPage < 1) curPage = 1;
		if(rowSizePerPage < 1) rowSizePerPage = 10;
		if(pageSize < 1) pageSize = 10;
		totalPageCount = (int) Math.ceil(totalRowCount/(double)rowSizePerPage);  
		firstRow = (curPage - 1) * rowSizePerPage + 1;
		lastRow = curPage * rowSizePerPage;
		
		firstPage = ((curPage-1) / pageSize) * pageSize + 1;
		lastPage = firstPage + pageSize - 1;
		if(lastPage > totalPageCount) lastPage = totalPageCount;		
		
		// pageSize 10, totalPageCount 73 
		// curPage   firstPage  lastPage 
		//  1 ~ 10      1           10
		//  11 ~ 20     11          20
    //  41 ~ 50     41          50
    //  71 ~ 73     71          73
		// firstPage = 
		
		// pageSize 5
		// curPage   firstPage  lastPage 
		//  1 ~ 5      1           5
		//  6 ~ 10     6          10
    //  41 ~ 45     41          45
    //  71 ~ 75     71          75
		// firstPage = 

		
  }
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getRowSizePerPage() {
		return rowSizePerPage;
	}

	public void setRowSizePerPage(int rowSizePerPage) {
		this.rowSizePerPage = rowSizePerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}

	public int getLastRow() {
		return lastRow;
	}

	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}

	public int getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	
	
}
