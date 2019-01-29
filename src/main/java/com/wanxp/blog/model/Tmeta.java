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
@Table(name = "meta")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Tmeta implements java.io.Serializable,IEntity{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Meta";
	public static final String ALIAS_ID = "主键";
	public static final String ALIAS_TENANT_ID = "租户ID";
	public static final String ALIAS_ADDTIME = "添加时间";
	public static final String ALIAS_UPDATETIME = "修改时间";
	public static final String ALIAS_ISDELETED = "是否删除,1删除，0未删除";
	public static final String ALIAS_NAME = "name";
	public static final String ALIAS_SLUG = "slug";
	public static final String ALIAS_TYPE = "type";
	public static final String ALIAS_DESCRIPTION = "description";
	public static final String ALIAS_SORT = "sort";
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
	//@NotBlank @Length(max=200)
	private String name;
	//@Length(max=200)
	private String slug;
	//@NotBlank @Length(max=32)
	private String type;
	//@Length(max=255)
	private String description;
	//
	private Integer sort;
	//
	private Integer parent;
	//columns END


		public Tmeta(){
		}
		public Tmeta(Integer id) {
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
	
	@Column(name = "name", unique = false, nullable = false, insertable = true, updatable = true, length = 200)
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "slug", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public String getSlug() {
		return this.slug;
	}
	
	public void setSlug(String slug) {
		this.slug = slug;
	}
	
	@Column(name = "type", unique = false, nullable = false, insertable = true, updatable = true, length = 32)
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name = "description", unique = false, nullable = true, insertable = true, updatable = true, length = 255)
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "sort", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Integer getSort() {
		return this.sort;
	}
	
	public void setSort(Integer sort) {
		this.sort = sort;
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
			.append("Name",getName())
			.append("Slug",getSlug())
			.append("Type",getType())
			.append("Description",getDescription())
			.append("Sort",getSort())
			.append("Parent",getParent())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Meta == false) return false;
		if(this == obj) return true;
		Meta other = (Meta)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}*/
}

