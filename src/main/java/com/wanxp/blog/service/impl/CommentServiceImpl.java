package com.wanxp.blog.service.impl;

import com.wanxp.blog.dao.CommentDaoI;
import com.wanxp.blog.model.Tcomment;
import com.wanxp.blog.pageModel.Comment;
import com.wanxp.blog.pageModel.DataGrid;
import com.wanxp.blog.pageModel.PageHelper;
import com.wanxp.blog.service.CommentServiceI;
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
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentServiceI {

	@Autowired
	private CommentDaoI commentDao;

	@Override
	public DataGrid dataGrid(Comment comment, PageHelper ph) {
		List<Comment> ol = new ArrayList<Comment>();
		String hql = " from Tcomment t ";
		DataGrid dg = dataGridQuery(hql, ph, comment, commentDao);
		@SuppressWarnings("unchecked")
		List<Tcomment> l = dg.getRows();
		if (l != null && l.size() > 0) {
			for (Tcomment t : l) {
				Comment o = new Comment();
				BeanUtils.copyProperties(t, o);
				ol.add(o);
			}
		}
		dg.setRows(ol);
		return dg;
	}
	

	protected String whereHql(Comment comment, Map<String, Object> params) {
		String whereHql = "";	
		if (comment != null) {
			whereHql += " where t.isdeleted = 0 ";
			if (!F.empty(comment.getTenantId())) {
				whereHql += " and t.tenantId = :tenantId";
				params.put("tenantId", comment.getTenantId());
			}		
			if (!F.empty(comment.getIsdeleted())) {
				whereHql += " and t.isdeleted = :isdeleted";
				params.put("isdeleted", comment.getIsdeleted());
			}		
			if (!F.empty(comment.getCid())) {
				whereHql += " and t.cid = :cid";
				params.put("cid", comment.getCid());
			}		
			if (!F.empty(comment.getCreated())) {
				whereHql += " and t.created = :created";
				params.put("created", comment.getCreated());
			}		
			if (!F.empty(comment.getAuthor())) {
				whereHql += " and t.author = :author";
				params.put("author", comment.getAuthor());
			}		
			if (!F.empty(comment.getAuthorId())) {
				whereHql += " and t.authorId = :authorId";
				params.put("authorId", comment.getAuthorId());
			}		
			if (!F.empty(comment.getOwnerId())) {
				whereHql += " and t.ownerId = :ownerId";
				params.put("ownerId", comment.getOwnerId());
			}		
			if (!F.empty(comment.getMail())) {
				whereHql += " and t.mail = :mail";
				params.put("mail", comment.getMail());
			}		
			if (!F.empty(comment.getUrl())) {
				whereHql += " and t.url = :url";
				params.put("url", comment.getUrl());
			}		
			if (!F.empty(comment.getIp())) {
				whereHql += " and t.ip = :ip";
				params.put("ip", comment.getIp());
			}		
			if (!F.empty(comment.getAgent())) {
				whereHql += " and t.agent = :agent";
				params.put("agent", comment.getAgent());
			}		
			if (!F.empty(comment.getContent())) {
				whereHql += " and t.content = :content";
				params.put("content", comment.getContent());
			}		
			if (!F.empty(comment.getType())) {
				whereHql += " and t.type = :type";
				params.put("type", comment.getType());
			}		
			if (!F.empty(comment.getStatus())) {
				whereHql += " and t.status = :status";
				params.put("status", comment.getStatus());
			}		
			if (!F.empty(comment.getParent())) {
				whereHql += " and t.parent = :parent";
				params.put("parent", comment.getParent());
			}		
		}	
		return whereHql;
	}

	@Override
	public void add(Comment comment) {
		Tcomment t = new Tcomment();
		BeanUtils.copyProperties(comment, t);
		//t.setId(jb.absx.UUID.uuid());
		t.setIsdeleted(false);
		commentDao.save(t);
	}

	@Override
	public Comment get(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Tcomment t = commentDao.get("from Tcomment t  where t.id = :id", params);
		Comment o = new Comment();
		BeanUtils.copyProperties(t, o);
		return o;
	}

	@Override
	public void edit(Comment comment) {
		Tcomment t = commentDao.get(Tcomment.class, comment.getId());
		if (t != null) {
			MyBeanUtils.copyProperties(comment, t, new String[] { "id" , "addtime", "isdeleted","updatetime" },true);
		}
	}

	@Override
	public void delete(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		commentDao.executeHql("update Tcomment t set t.isdeleted = 1 where t.id = :id",params);
		//commentDao.delete(commentDao.get(Tcomment.class, id));
	}

}
