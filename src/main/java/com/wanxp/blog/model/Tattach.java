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
@Table(name = "attach")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Tattach implements java.io.Serializable,IEntity{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Attach";
	public static final String ALIAS_ID = "主键";
	public static final String ALIAS_TENANT_ID = "租户ID";
	public static final String ALIAS_ADDTIME = "添加时间";
	public static final String ALIAS_UPDATETIME = "修改时间";
	public static final String ALIAS_ISDELETED = "是否删除,1删除，0未删除";
	public static final String ALIAS_FNAME = "fname";
	public static final String ALIAS_FTYPE = "ftype";
	public static final String ALIAS_FKEY = "fkey";
	public static final String ALIAS_AUTHOR_ID = "authorId";
	public static final String ALIAS_CREATED = "created";
	
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
	//@NotBlank @Length(max=100)
	private String fname;
	//@Length(max=50)
	private String ftype;
	//@NotBlank @Length(max=100)
	private String fkey;
	//@NotNull 
	private Integer authorId;
	//@NotNull 
	private Integer created;
	//columns END


		public Tattach(){
		}
		public Tattach(Integer id) {
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
	
	@Column(name = "fname", unique = false, nullable = false, insertable = true, updatable = true, length = 100)
	public String getFname() {
		return this.fname;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	@Column(name = "ftype", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public String getFtype() {
		return this.ftype;
	}
	
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}
	
	@Column(name = "fkey", unique = false, nullable = false, insertable = true, updatable = true, length = 100)
	public String getFkey() {
		return this.fkey;
	}
	
	public void setFkey(String fkey) {
		this.fkey = fkey;
	}
	
	@Column(name = "author_id", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public Integer getAuthorId() {
		return this.authorId;
	}
	
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	
	@Column(name = "created", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public Integer getCreated() {
		return this.created;
	}
	
	public void setCreated(Integer created) {
		this.created = created;
	}
	
	
	/*
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("TenantId",getTenantId())
			.append("Addtime",getAddtime())
			.append("Updatetime",getUpdatetime())
			.append("Isdeleted",getIsdeleted())
			.append("Fname",getFname())
			.append("Ftype",getFtype())
			.append("Fkey",getFkey())
			.append("AuthorId",getAuthorId())
			.append("Created",getCreated())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Attach == false) return false;
		if(this == obj) return true;
		Attach other = (Attach)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}*/
}

