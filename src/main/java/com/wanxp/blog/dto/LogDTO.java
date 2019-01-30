package com.wanxp.blog.dto;

import java.util.Date;

@SuppressWarnings("serial")
public class LogDTO implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private Integer id;
	private Integer tenantId;
	private Date addtime;			
	private Date updatetime;			
	private Boolean isdeleted;
	private String action;
	private String data;
	private Integer authorId;
	private String ip;
	private Integer created;

	

	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}

	
	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}
	
	public Integer getTenantId() {
		return this.tenantId;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	
	public Date getAddtime() {
		return this.addtime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
	public Date getUpdatetime() {
		return this.updatetime;
	}
	public void setIsdeleted(Boolean isdeleted) {
		this.isdeleted = isdeleted;
	}
	
	public Boolean getIsdeleted() {
		return this.isdeleted;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	public String getAction() {
		return this.action;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String getData() {
		return this.data;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	
	public Integer getAuthorId() {
		return this.authorId;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public String getIp() {
		return this.ip;
	}
	public void setCreated(Integer created) {
		this.created = created;
	}
	
	public Integer getCreated() {
		return this.created;
	}

}
