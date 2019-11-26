package com.cy.res.common.vo;

import java.io.Serializable;
import java.util.List;

public class PageObject<T> implements Serializable {
	private static final long serialVersionUID = -2959869905947970474L;
	
	private List<T> records;//当前页记录
	private Integer rowCount;//总行数
	private Integer PageCount;//总页数
	private Integer PageCurrent;//当前页面
	private Integer PageSize;//页面大小
	
	public PageObject() {}

	public PageObject(List<T> records, Integer rowCount, Integer pageCurrent, Integer pageSize) {
		super();
		this.records = records;
		this.rowCount = rowCount;
		PageCurrent = pageCurrent;
		PageSize = pageSize;
		this.PageCount = rowCount/pageSize;
		if (rowCount%pageSize!=0) {
			this.PageCount++;
		}
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> record) {
		this.records = record;
	}

	public Integer getRowCount() {
		return rowCount;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	public Integer getPageCount() {
		return PageCount;
	}

	public void setPageCount(Integer pageCount) {
		PageCount = pageCount;
	}

	public Integer getPageCurrent() {
		return PageCurrent;
	}

	public void setPageCurrent(Integer pageCurrent) {
		PageCurrent = pageCurrent;
	}

	public Integer getPageSize() {
		return PageSize;
	}

	public void setPageSize(Integer pageSize) {
		PageSize = pageSize;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
