/*
 * @author John
 * @date - 2018-02-04
 */

package com.wanxp.blog.model;

import javax.persistence.*;

import java.util.Date;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@SuppressWarnings("serial")
@Entity
@Table(name = "comment")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Tcomment implements java.io.Serializable,IEntity{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Comment";
	public static final String ALIAS_ID = "主键";
	public static final String ALIAS_TENANT_ID = "租户ID";
	public static final String ALIAS_ADDTIME = "添加时间";
	public static final String ALIAS_UPDATETIME = "修改时间";
	public static final String ALIAS_ISDELETED = "是否删除,1删除，0未删除";
	public static final String ALIAS_CID = "cid";
	public static final String ALIAS_CREATED = "created";
	public static final String ALIAS_AUTHOR = "author";
	public static final String ALIAS_AUTHOR_ID = "authorId";
	public static final String ALIAS_OWNER_ID = "ownerId";
	public static final String ALIAS_MAIL = "mail";
	public static final String ALIAS_URL = "url";
	public static final String ALIAS_IP = "ip";
	public static final String ALIAS_AGENT = "agent";
	public static final String ALIAS_CONTENT = "content";
	public static final String ALIAS_TYPE = "type";
	public static final String ALIAS_STATUS = "status";
	public static final String ALIAS_PARENT = "parent";
	
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
	//@NotNull 
	private Integer cid;
	//@NotNull 
	private Integer created;
	//@NotBlank @Length(max=200)
	private String author;
	//
	private Integer authorId;
	//
	private Integer ownerId;
	//@NotBlank @Email @Length(max=200)
	private String mail;
	//@Length(max=200)
	private String url;
	//@Length(max=64)
	private String ip;
	//@Length(max=200)
	private String agent;
	//@NotBlank @Length(max=16777215)
	private String content;
	//@Length(max=16)
	private String type;
	//@Length(max=16)
	private String status;
	//
	private Integer parent;
	//columns END


		public Tcomment(){
		}
		public Tcomment(Integer id) {
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
	
	@Column(name = "cid", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public Integer getCid() {
		return this.cid;
	}
	
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	@Column(name = "created", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public Integer getCreated() {
		return this.created;
	}
	
	public void setCreated(Integer created) {
		this.created = created;
	}
	
	@Column(name = "author", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	public String getAuthor() {
		return this.author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Column(name = "author_id", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Integer getAuthorId() {
		return this.authorId;
	}
	
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	
	@Column(name = "owner_id", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Integer getOwnerId() {
		return this.ownerId;
	}
	
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	
	@Column(name = "mail", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	public String getMail() {
		return this.mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Column(name = "url", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Column(name = "ip", unique = false, nullable = true, insertable = true, updatable = true, length = 64)
	public String getIp() {
		return this.ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Column(name = "agent", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public String getAgent() {
		return this.agent;
	}
	
	public void setAgent(String agent) {
		this.agent = agent;
	}
	
	@Column(name = "content", unique = false, nullable = false, insertable = true, updatable = true, length = 16777215)
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name = "type", unique = false, nullable = true, insertable = true, updatable = true, length = 16)
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name = "status", unique = false, nullable = true, insertable = true, updatable = true, length = 16)
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "parent", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Integer getParent() {
		return this.parent;
	}
	
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	
	
	/*
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("TenantId",getTenantId())
			.append("Addtime",getAddtime())
			.append("Updatetime",getUpdatetime())
			.append("Isdeleted",getIsdeleted())
			.append("Cid",getCid())
			.append("Created",getCreated())
			.append("Author",getAuthor())
			.append("AuthorId",getAuthorId())
			.append("OwnerId",getOwnerId())
			.append("Mail",getMail())
			.append("Url",getUrl())
			.append("Ip",getIp())
			.append("Agent",getAgent())
			.append("Content",getContent())
			.append("Type",getType())
			.append("Status",getStatus())
			.append("Parent",getParent())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Comment == false) return false;
		if(this == obj) return true;
		Comment other = (Comment)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}*/
}

