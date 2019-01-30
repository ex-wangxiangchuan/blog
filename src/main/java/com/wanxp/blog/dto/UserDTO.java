package com.wanxp.blog.dto;

import java.util.Date;

@SuppressWarnings("serial")
public class UserDTO implements java.io.Serializable {

	private static final long serialVersionUID = 5454155825314635342L;

	private Integer id;
	private Integer tenantId;
	private Date addtime;			
	private Date updatetime;			
	private Boolean isdeleted;
	private String username;
	private String password;
	private String email;
	private String homeUrl;
	private String screenName;
	private Integer created;
	private Integer activated;
	private Integer logged;
	private String groupName;

	

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
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	public void setHomeUrl(String homeUrl) {
		this.homeUrl = homeUrl;
	}
	
	public String getHomeUrl() {
		return this.homeUrl;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
	public String getScreenName() {
		return this.screenName;
	}
	public void setCreated(Integer created) {
		this.created = created;
	}
	
	public Integer getCreated() {
		return this.created;
	}
	public void setActivated(Integer activated) {
		this.activated = activated;
	}
	
	public Integer getActivated() {
		return this.activated;
	}
	public void setLogged(Integer logged) {
		this.logged = logged;
	}
	
	public Integer getLogged() {
		return this.logged;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public String getGroupName() {
		return this.groupName;
	}

}
