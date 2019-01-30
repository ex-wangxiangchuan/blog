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
@Table(name = "content")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Content implements java.io.Serializable,IEntity{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Content";
	public static final String ALIAS_ID = "主键";
	public static final String ALIAS_TENANT_ID = "租户ID";
	public static final String ALIAS_ADDTIME = "添加时间";
	public static final String ALIAS_UPDATETIME = "修改时间";
	public static final String ALIAS_ISDELETED = "是否删除,1删除，0未删除";
	public static final String ALIAS_TITLE = "title";
	public static final String ALIAS_SLUG = "slug";
	public static final String ALIAS_THUMB_IMG = "thumbImg";
	public static final String ALIAS_CREATED = "created";
	public static final String ALIAS_MODIFIED = "modified";
	public static final String ALIAS_CONTENT = "content";
	public static final String ALIAS_AUTHOR_ID = "authorId";
	public static final String ALIAS_TYPE = "type";
	public static final String ALIAS_STATUS = "status";
	public static final String ALIAS_FMT_TYPE = "fmtType";
	public static final String ALIAS_TAGS = "tags";
	public static final String ALIAS_CATEGORIES = "categories";
	public static final String ALIAS_HITS = "hits";
	public static final String ALIAS_COMMENTS_NUM = "commentsNum";
	public static final String ALIAS_ALLOW_COMMENT = "allowComment";
	public static final String ALIAS_ALLOW_PING = "allowPing";
	public static final String ALIAS_ALLOW_FEED = "allowFeed";
	
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
	//@NotBlank @Length(max=255)
	private String title;
	//@Length(max=255)
	private String slug;
	//@Length(max=255)
	private String thumbImg;
	//@NotNull 
	private Integer created;
	//
	private Integer modified;
	//@Length(max=16777215)
	private String content;
	//@NotNull 
	private Integer authorId;
	//@NotBlank @Length(max=16)
	private String type;
	//@NotBlank @Length(max=16)
	private String status;
	//@Length(max=16)
	private String fmtType;
	//@Length(max=200)
	private String tags;
	//@Length(max=200)
	private String categories;
	//
	private Integer hits;
	//
	private Integer commentsNum;
	//
	private Integer allowComment;
	//
	private Integer allowPing;
	//
	private Integer allowFeed;
	//columns END


		public Content(){
		}
		public Content(Integer id) {
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
	
	@Column(name = "title", unique = false, nullable = false, insertable = true, updatable = true, length = 255)
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "slug", unique = true, nullable = true, insertable = true, updatable = true, length = 255)
	public String getSlug() {
		return this.slug;
	}
	
	public void setSlug(String slug) {
		this.slug = slug;
	}
	
	@Column(name = "thumb_img", unique = false, nullable = true, insertable = true, updatable = true, length = 255)
	public String getThumbImg() {
		return this.thumbImg;
	}
	
	public void setThumbImg(String thumbImg) {
		this.thumbImg = thumbImg;
	}
	
	@Column(name = "created", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public Integer getCreated() {
		return this.created;
	}
	
	public void setCreated(Integer created) {
		this.created = created;
	}
	
	@Column(name = "modified", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Integer getModified() {
		return this.modified;
	}
	
	public void setModified(Integer modified) {
		this.modified = modified;
	}
	
	@Column(name = "content", unique = false, nullable = true, insertable = true, updatable = true, length = 16777215)
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name = "author_id", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public Integer getAuthorId() {
		return this.authorId;
	}
	
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	
	@Column(name = "type", unique = false, nullable = false, insertable = true, updatable = true, length = 16)
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name = "status", unique = false, nullable = false, insertable = true, updatable = true, length = 16)
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "fmt_type", unique = false, nullable = true, insertable = true, updatable = true, length = 16)
	public String getFmtType() {
		return this.fmtType;
	}
	
	public void setFmtType(String fmtType) {
		this.fmtType = fmtType;
	}
	
	@Column(name = "tags", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public String getTags() {
		return this.tags;
	}
	
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	@Column(name = "categories", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public String getCategories() {
		return this.categories;
	}
	
	public void setCategories(String categories) {
		this.categories = categories;
	}
	
	@Column(name = "hits", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Integer getHits() {
		return this.hits;
	}
	
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	
	@Column(name = "comments_num", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Integer getCommentsNum() {
		return this.commentsNum;
	}
	
	public void setCommentsNum(Integer commentsNum) {
		this.commentsNum = commentsNum;
	}
	
	@Column(name = "allow_comment", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Integer getAllowComment() {
		return this.allowComment;
	}
	
	public void setAllowComment(Integer allowComment) {
		this.allowComment = allowComment;
	}
	
	@Column(name = "allow_ping", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Integer getAllowPing() {
		return this.allowPing;
	}
	
	public void setAllowPing(Integer allowPing) {
		this.allowPing = allowPing;
	}
	
	@Column(name = "allow_feed", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public Integer getAllowFeed() {
		return this.allowFeed;
	}
	
	public void setAllowFeed(Integer allowFeed) {
		this.allowFeed = allowFeed;
	}
	
	
	/*
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("TenantId",getTenantId())
			.append("Addtime",getAddtime())
			.append("Updatetime",getUpdatetime())
			.append("Isdeleted",getIsdeleted())
			.append("Title",getTitle())
			.append("Slug",getSlug())
			.append("ThumbImg",getThumbImg())
			.append("Created",getCreated())
			.append("Modified",getModified())
			.append("Content",getContent())
			.append("AuthorId",getAuthorId())
			.append("Type",getType())
			.append("Status",getStatus())
			.append("FmtType",getFmtType())
			.append("Tags",getTags())
			.append("Categories",getCategories())
			.append("Hits",getHits())
			.append("CommentsNum",getCommentsNum())
			.append("AllowComment",getAllowComment())
			.append("AllowPing",getAllowPing())
			.append("AllowFeed",getAllowFeed())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Content == false) return false;
		if(this == obj) return true;
		Content other = (Content)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}*/
}

