package com.wanxp.blog.dto;

public class ColumDTO {
	private String field;
	private boolean hidden;
	private String title;
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
