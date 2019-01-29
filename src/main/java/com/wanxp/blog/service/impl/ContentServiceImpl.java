package com.wanxp.blog.service.impl;

import com.wanxp.blog.dao.ContentDaoI;
import com.wanxp.blog.model.Tcontent;
import com.wanxp.blog.pageModel.Content;
import com.wanxp.blog.pageModel.DataGrid;
import com.wanxp.blog.pageModel.PageHelper;
import com.wanxp.blog.service.ContentServiceI;
import com.wanxp.blog.util.F;
import com.wanxp.blog.util.MyBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContentServiceImpl extends BaseServiceImpl<Content> implements ContentServiceI {

	@Autowired
	private ContentDaoI contentDao;

	@Override
	public DataGrid dataGrid(Content content, PageHelper ph) {
		List<Content> ol = new ArrayList<Content>();
		String hql = " from Tcontent t ";
		DataGrid dg = dataGridQuery(hql, ph, content, contentDao);
		@SuppressWarnings("unchecked")
		List<Tcontent> l = dg.getRows();
		if (l != null && l.size() > 0) {
			for (Tcontent t : l) {
				Content o = new Content();
				BeanUtils.copyProperties(t, o);
				ol.add(o);
			}
		}
		dg.setRows(ol);
		return dg;
	}
	

	protected String whereHql(Content content, Map<String, Object> params) {
		String whereHql = "";	
		if (content != null) {
			whereHql += " where t.isdeleted = 0 ";
			if (!F.empty(content.getTenantId())) {
				whereHql += " and t.tenantId = :tenantId";
				params.put("tenantId", content.getTenantId());
			}		
			if (!F.empty(content.getIsdeleted())) {
				whereHql += " and t.isdeleted = :isdeleted";
				params.put("isdeleted", content.getIsdeleted());
			}		
			if (!F.empty(content.getTitle())) {
				whereHql += " and t.title = :title";
				params.put("title", content.getTitle());
			}		
			if (!F.empty(content.getSlug())) {
				whereHql += " and t.slug = :slug";
				params.put("slug", content.getSlug());
			}		
			if (!F.empty(content.getThumbImg())) {
				whereHql += " and t.thumbImg = :thumbImg";
				params.put("thumbImg", content.getThumbImg());
			}		
			if (!F.empty(content.getCreated())) {
				whereHql += " and t.created = :created";
				params.put("created", content.getCreated());
			}		
			if (!F.empty(content.getModified())) {
				whereHql += " and t.modified = :modified";
				params.put("modified", content.getModified());
			}		
			if (!F.empty(content.getContent())) {
				whereHql += " and t.content = :content";
				params.put("content", content.getContent());
			}		
			if (!F.empty(content.getAuthorId())) {
				whereHql += " and t.authorId = :authorId";
				params.put("authorId", content.getAuthorId());
			}		
			if (!F.empty(content.getType())) {
				whereHql += " and t.type = :type";
				params.put("type", content.getType());
			}		
			if (!F.empty(content.getStatus())) {
				whereHql += " and t.status = :status";
				params.put("status", content.getStatus());
			}		
			if (!F.empty(content.getFmtType())) {
				whereHql += " and t.fmtType = :fmtType";
				params.put("fmtType", content.getFmtType());
			}		
			if (!F.empty(content.getTags())) {
				whereHql += " and t.tags = :tags";
				params.put("tags", content.getTags());
			}		
			if (!F.empty(content.getCategories())) {
				whereHql += " and t.categories = :categories";
				params.put("categories", content.getCategories());
			}		
			if (!F.empty(content.getHits())) {
				whereHql += " and t.hits = :hits";
				params.put("hits", content.getHits());
			}		
			if (!F.empty(content.getCommentsNum())) {
				whereHql += " and t.commentsNum = :commentsNum";
				params.put("commentsNum", content.getCommentsNum());
			}		
			if (!F.empty(content.getAllowComment())) {
				whereHql += " and t.allowComment = :allowComment";
				params.put("allowComment", content.getAllowComment());
			}		
			if (!F.empty(content.getAllowPing())) {
				whereHql += " and t.allowPing = :allowPing";
				params.put("allowPing", content.getAllowPing());
			}		
			if (!F.empty(content.getAllowFeed())) {
				whereHql += " and t.allowFeed = :allowFeed";
				params.put("allowFeed", content.getAllowFeed());
			}		
		}	
		return whereHql;
	}

	@Override
	public void add(Content content) {
		Tcontent t = new Tcontent();
		BeanUtils.copyProperties(content, t);
		//t.setId(jb.absx.UUID.uuid());
		t.setIsdeleted(false);
		contentDao.save(t);
	}

	@Override
	public Content get(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Tcontent t = contentDao.get("from Tcontent t  where t.id = :id", params);
		Content o = new Content();
		BeanUtils.copyProperties(t, o);
		return o;
	}

	@Override
	public void edit(Content content) {
		Tcontent t = contentDao.get(Tcontent.class, content.getId());
		if (t != null) {
			MyBeanUtils.copyProperties(content, t, new String[] { "id" , "addtime", "isdeleted","updatetime" },true);
		}
	}

	@Override
	public void delete(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		contentDao.executeHql("update Tcontent t set t.isdeleted = 1 where t.id = :id",params);
		//contentDao.delete(contentDao.get(Tcontent.class, id));
	}

}
