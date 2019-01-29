package com.wanxp.blog.service.impl;

import com.wanxp.blog.dao.ContentMetaRelationshipDaoI;
import com.wanxp.blog.model.TcontentMetaRelationship;
import com.wanxp.blog.pageModel.ContentMetaRelationship;
import com.wanxp.blog.pageModel.DataGrid;
import com.wanxp.blog.pageModel.PageHelper;
import com.wanxp.blog.service.ContentMetaRelationshipServiceI;
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
public class ContentMetaRelationshipServiceImpl extends BaseServiceImpl<ContentMetaRelationship> implements ContentMetaRelationshipServiceI {

	@Autowired
	private ContentMetaRelationshipDaoI contentMetaRelationshipDao;

	@Override
	public DataGrid dataGrid(ContentMetaRelationship contentMetaRelationship, PageHelper ph) {
		List<ContentMetaRelationship> ol = new ArrayList<ContentMetaRelationship>();
		String hql = " from TcontentMetaRelationship t ";
		DataGrid dg = dataGridQuery(hql, ph, contentMetaRelationship, contentMetaRelationshipDao);
		@SuppressWarnings("unchecked")
		List<TcontentMetaRelationship> l = dg.getRows();
		if (l != null && l.size() > 0) {
			for (TcontentMetaRelationship t : l) {
				ContentMetaRelationship o = new ContentMetaRelationship();
				BeanUtils.copyProperties(t, o);
				ol.add(o);
			}
		}
		dg.setRows(ol);
		return dg;
	}
	

	protected String whereHql(ContentMetaRelationship contentMetaRelationship, Map<String, Object> params) {
		String whereHql = "";	
		if (contentMetaRelationship != null) {
			whereHql += " where t.isdeleted = 0 ";
			if (!F.empty(contentMetaRelationship.getTenantId())) {
				whereHql += " and t.tenantId = :tenantId";
				params.put("tenantId", contentMetaRelationship.getTenantId());
			}		
			if (!F.empty(contentMetaRelationship.getIsdeleted())) {
				whereHql += " and t.isdeleted = :isdeleted";
				params.put("isdeleted", contentMetaRelationship.getIsdeleted());
			}		
			if (!F.empty(contentMetaRelationship.getContentId())) {
				whereHql += " and t.contentId = :contentId";
				params.put("contentId", contentMetaRelationship.getContentId());
			}		
			if (!F.empty(contentMetaRelationship.getMetaId())) {
				whereHql += " and t.metaId = :metaId";
				params.put("metaId", contentMetaRelationship.getMetaId());
			}		
		}	
		return whereHql;
	}

	@Override
	public void add(ContentMetaRelationship contentMetaRelationship) {
		TcontentMetaRelationship t = new TcontentMetaRelationship();
		BeanUtils.copyProperties(contentMetaRelationship, t);
		//t.setId(jb.absx.UUID.uuid());
		t.setIsdeleted(false);
		contentMetaRelationshipDao.save(t);
	}

	@Override
	public ContentMetaRelationship get(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		TcontentMetaRelationship t = contentMetaRelationshipDao.get("from TcontentMetaRelationship t  where t.id = :id", params);
		ContentMetaRelationship o = new ContentMetaRelationship();
		BeanUtils.copyProperties(t, o);
		return o;
	}

	@Override
	public void edit(ContentMetaRelationship contentMetaRelationship) {
		TcontentMetaRelationship t = contentMetaRelationshipDao.get(TcontentMetaRelationship.class, contentMetaRelationship.getId());
		if (t != null) {
			MyBeanUtils.copyProperties(contentMetaRelationship, t, new String[] { "id" , "addtime", "isdeleted","updatetime" },true);
		}
	}

	@Override
	public void delete(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		contentMetaRelationshipDao.executeHql("update TcontentMetaRelationship t set t.isdeleted = 1 where t.id = :id",params);
		//contentMetaRelationshipDao.delete(contentMetaRelationshipDao.get(TcontentMetaRelationship.class, id));
	}

}
