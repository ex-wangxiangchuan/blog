package com.wanxp.blog.pageModel;

import java.util.Date;

@SuppressWarnings("serial")
public class Comment implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private Integer id;
	private Integer tenantId;
	private Date addtime;			
	private Date updatetime;			
	private Boolean isdeleted;
	private Integer cid;
	private Integer created;
	private String author;
	private Integer authorId;
	private Integer ownerId;
	private String mail;
	private String url;
	private String ip;
	private String agent;
	private String content;
	private String type;
	private String status;
	private Integer parent;

	

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
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	public Integer getCid() {
		return this.cid;
	}
	public void setCreated(Integer created) {
		this.created = created;
	}
	
	public Integer getCreated() {
		return this.created;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getAuthor() {
		return this.author;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	
	public Integer getAuthorId() {
		return this.authorId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	
	public Integer getOwnerId() {
		return this.ownerId;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getMail() {
		return this.mail;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return this.url;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public String getIp() {
		return this.ip;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	
	public String getAgent() {
		return this.agent;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return this.content;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	
	public Integer getParent() {
		return this.parent;
	}

}
