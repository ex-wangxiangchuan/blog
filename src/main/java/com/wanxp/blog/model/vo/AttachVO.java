package com.wanxp.blog.model.vo;

import java.util.Date;

@SuppressWarnings("serial")
public class AttachVO implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private Integer id;
	private Integer tenantId;
	private Date addtime;			
	private Date updatetime;			
	private Boolean isdeleted;
	private String fname;
	private String ftype;
	private String fkey;
	private Integer authorId;
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
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getFname() {
		return this.fname;
	}
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}
	
	public String getFtype() {
		return this.ftype;
	}
	public void setFkey(String fkey) {
		this.fkey = fkey;
	}
	
	public String getFkey() {
		return this.fkey;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	
	public Integer getAuthorId() {
		return this.authorId;
	}
	public void setCreated(Integer created) {
		this.created = created;
	}
	
	public Integer getCreated() {
		return this.created;
	}

}
