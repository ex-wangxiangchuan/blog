package com.wanxp.blog.model.dto;

import java.util.Date;

@SuppressWarnings("serial")
public class ContentDTO implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private Integer id;
	private Integer tenantId;
	private Date addtime;			
	private Date updatetime;			
	private Boolean isdeleted;
	private String title;
	private String slug;
	private String thumbImg;
	private Integer created;
	private Integer modified;
	private String content;
	private Integer authorId;
	private String type;
	private String status;
	private String fmtType;
	private String tags;
	private String categories;
	private Integer hits;
	private Integer commentsNum;
	private Integer allowComment;
	private Integer allowPing;
	private Integer allowFeed;

	

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
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	
	public String getSlug() {
		return this.slug;
	}
	public void setThumbImg(String thumbImg) {
		this.thumbImg = thumbImg;
	}
	
	public String getThumbImg() {
		return this.thumbImg;
	}
	public void setCreated(Integer created) {
		this.created = created;
	}
	
	public Integer getCreated() {
		return this.created;
	}
	public void setModified(Integer modified) {
		this.modified = modified;
	}
	
	public Integer getModified() {
		return this.modified;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return this.content;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	
	public Integer getAuthorId() {
		return this.authorId;
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
	public void setFmtType(String fmtType) {
		this.fmtType = fmtType;
	}
	
	public String getFmtType() {
		return this.fmtType;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	public String getTags() {
		return this.tags;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	
	public String getCategories() {
		return this.categories;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	
	public Integer getHits() {
		return this.hits;
	}
	public void setCommentsNum(Integer commentsNum) {
		this.commentsNum = commentsNum;
	}
	
	public Integer getCommentsNum() {
		return this.commentsNum;
	}
	public void setAllowComment(Integer allowComment) {
		this.allowComment = allowComment;
	}
	
	public Integer getAllowComment() {
		return this.allowComment;
	}
	public void setAllowPing(Integer allowPing) {
		this.allowPing = allowPing;
	}
	
	public Integer getAllowPing() {
		return this.allowPing;
	}
	public void setAllowFeed(Integer allowFeed) {
		this.allowFeed = allowFeed;
	}
	
	public Integer getAllowFeed() {
		return this.allowFeed;
	}

}
