package com.wanxp.blog.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * EasyUI DataGrid模型
 * 
 * @author John
 * 
 */
@SuppressWarnings("serial")
public class DataGrid implements java.io.Serializable {

	private Long total = 0L;
	@SuppressWarnings("rawtypes")
	private List rows = new ArrayList();
	private List footer = new ArrayList();

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	@SuppressWarnings("rawtypes")
	public List getRows() {
		return rows;
	}

	@SuppressWarnings("rawtypes")
	public void setRows(List rows) {
		this.rows = rows;
	}

	public List getFooter() {
		return footer;
	}

	public void setFooter(List footer) {
		this.footer = footer;
	}
}
