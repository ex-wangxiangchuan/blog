package com.wanxp.blog.pageModel;

import java.util.Date;

@SuppressWarnings("serial")
public class ContentMetaRelationship implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private Integer id;
	private Integer tenantId;
	private Date addtime;			
	private Date updatetime;			
	private Boolean isdeleted;
	private Integer contentId;
	private Integer metaId;

	

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
	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}
	
	public Integer getContentId() {
		return this.contentId;
	}
	public void setMetaId(Integer metaId) {
		this.metaId = metaId;
	}
	
	public Integer getMetaId() {
		return this.metaId;
	}

}
