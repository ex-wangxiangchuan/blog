/*
 * @author John
 * @date - 2018-02-04
 */

package com.wanxp.blog.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "user")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Tuser implements java.io.Serializable,IEntity{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "User";
	public static final String ALIAS_ID = "主键";
	public static final String ALIAS_TENANT_ID = "租户ID";
	public static final String ALIAS_ADDTIME = "添加时间";
	public static final String ALIAS_UPDATETIME = "修改时间";
	public static final String ALIAS_ISDELETED = "是否删除,1删除，0未删除";
	public static final String ALIAS_USERNAME = "username";
	public static final String ALIAS_PASSWORD = "password";
	public static final String ALIAS_EMAIL = "email";
	public static final String ALIAS_HOME_URL = "homeUrl";
	public static final String ALIAS_SCREEN_NAME = "screenName";
	public static final String ALIAS_CREATED = "created";
	public static final String ALIAS_ACTIVATED = "activated";
	public static final String ALIAS_LOGGED = "logged";
	public static final String ALIAS_GROUP_NAME = "groupName";
	
	//date formats
	public static final String FORMAT_ADDTIME = com.wanxp.blog.util.Constants.DATE_FORMAT_FOR_ENTITY;
	public static final String FORMAT_UPDATETIME = com.wanxp.blog.util.Constants.DATE_FORMAT_FOR_ENTITY;
	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//
	private Integer id;
	//
	private Integer tenantId;
	//@NotNull 
	private Date addtime;
	//@NotNull 
	private Date updatetime;
	//@NotNull 
	private Boolean isdeleted;
	//@NotBlank @Length(max=64)
	private String username;
	//@NotBlank @Length(max=64)
	private String password;
	//@Email @Length(max=100)
	private String email;
	//@Length(max=255)
	private String homeUrl;
	//@Length(max=100)
	private String screenName;
	//@NotNull 
	private Integer created;
	//
	private Integer activated;
	//
	private Integer logged;
	//@Length(max=16)
	private String groupName;
	//columns END


		public Tuser(){
		}
		public Tuser(Integer id) {
			this.id = id;
		}
	

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, length = 10)
	public Integer getId() {
		return this.id;
	}
	
	@Column(name = "tenant_id", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Integer getTenantId() {
		return this.tenantId;
	}
	
	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}
	

	@Column(name = "addtime", unique = false, nullable = false, insertable = true, updatable = true, length = 19)
	public Date getAddtime() {
		return this.addtime;
	}
	
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	

	@Column(name = "updatetime", unique = false, nullable = false, insertable = true, updatable = true, length = 19)
	public Date getUpdatetime() {
		return this.updatetime;
	}
	
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
	@Column(name = "isdeleted", unique = false, nullable = false, insertable = true, updatable = true, length = 0)
	public Boolean getIsdeleted() {
		return this.isdeleted;
	}
	
	public void setIsdeleted(Boolean isdeleted) {
		this.isdeleted = isdeleted;
	}
	
	@Column(name = "username", unique = true, nullable = false, insertable = true, updatable = true, length = 64)
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "password", unique = false, nullable = false, insertable = true, updatable = true, length = 64)
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "email", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "home_url", unique = false, nullable = true, insertable = true, updatable = true, length = 255)
	public String getHomeUrl() {
		return this.homeUrl;
	}
	
	public void setHomeUrl(String homeUrl) {
		this.homeUrl = homeUrl;
	}
	
	@Column(name = "screen_name", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public String getScreenName() {
		return this.screenName;
	}
	
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
	@Column(name = "created", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public Integer getCreated() {
		return this.created;
	}
	
	public void setCreated(Integer created) {
		this.created = created;
	}
	
	@Column(name = "activated", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Integer getActivated() {
		return this.activated;
	}
	
	public void setActivated(Integer activated) {
		this.activated = activated;
	}
	
	@Column(name = "logged", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Integer getLogged() {
		return this.logged;
	}
	
	public void setLogged(Integer logged) {
		this.logged = logged;
	}
	
	@Column(name = "group_name", unique = false, nullable = true, insertable = true, updatable = true, length = 16)
	public String getGroupName() {
		return this.groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
	/*
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("TenantId",getTenantId())
			.append("Addtime",getAddtime())
			.append("Updatetime",getUpdatetime())
			.append("Isdeleted",getIsdeleted())
			.append("Username",getUsername())
			.append("Password",getPassword())
			.append("Email",getEmail())
			.append("HomeUrl",getHomeUrl())
			.append("ScreenName",getScreenName())
			.append("Created",getCreated())
			.append("Activated",getActivated())
			.append("Logged",getLogged())
			.append("GroupName",getGroupName())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof User == false) return false;
		if(this == obj) return true;
		User other = (User)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}*/
}

