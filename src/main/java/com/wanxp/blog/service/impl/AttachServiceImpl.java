package com.wanxp.blog.service.impl;

import com.wanxp.blog.dao.AttachDaoI;
import com.wanxp.blog.model.Tattach;
import com.wanxp.blog.pageModel.Attach;
import com.wanxp.blog.pageModel.DataGrid;
import com.wanxp.blog.pageModel.PageHelper;
import com.wanxp.blog.service.AttachServiceI;
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
public class AttachServiceImpl extends BaseServiceImpl<Attach> implements AttachServiceI {

	@Autowired
	private AttachDaoI attachDao;

	@Override
	public DataGrid dataGrid(Attach attach, PageHelper ph) {
		List<Attach> ol = new ArrayList<Attach>();
		String hql = " from Tattach t ";
		DataGrid dg = dataGridQuery(hql, ph, attach, attachDao);
		@SuppressWarnings("unchecked")
		List<Tattach> l = dg.getRows();
		if (l != null && l.size() > 0) {
			for (Tattach t : l) {
				Attach o = new Attach();
				BeanUtils.copyProperties(t, o);
				ol.add(o);
			}
		}
		dg.setRows(ol);
		return dg;
	}
	

	protected String whereHql(Attach attach, Map<String, Object> params) {
		String whereHql = "";	
		if (attach != null) {
			whereHql += " where t.isdeleted = 0 ";
			if (!F.empty(attach.getTenantId())) {
				whereHql += " and t.tenantId = :tenantId";
				params.put("tenantId", attach.getTenantId());
			}		
			if (!F.empty(attach.getIsdeleted())) {
				whereHql += " and t.isdeleted = :isdeleted";
				params.put("isdeleted", attach.getIsdeleted());
			}		
			if (!F.empty(attach.getFname())) {
				whereHql += " and t.fname = :fname";
				params.put("fname", attach.getFname());
			}		
			if (!F.empty(attach.getFtype())) {
				whereHql += " and t.ftype = :ftype";
				params.put("ftype", attach.getFtype());
			}		
			if (!F.empty(attach.getFkey())) {
				whereHql += " and t.fkey = :fkey";
				params.put("fkey", attach.getFkey());
			}		
			if (!F.empty(attach.getAuthorId())) {
				whereHql += " and t.authorId = :authorId";
				params.put("authorId", attach.getAuthorId());
			}		
			if (!F.empty(attach.getCreated())) {
				whereHql += " and t.created = :created";
				params.put("created", attach.getCreated());
			}		
		}	
		return whereHql;
	}

	@Override
	public void add(Attach attach) {
		Tattach t = new Tattach();
		BeanUtils.copyProperties(attach, t);
		//t.setId(jb.absx.UUID.uuid());
		t.setIsdeleted(false);
		attachDao.save(t);
	}

	@Override
	public Attach get(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Tattach t = attachDao.get("from Tattach t  where t.id = :id", params);
		Attach o = new Attach();
		BeanUtils.copyProperties(t, o);
		return o;
	}

	@Override
	public void edit(Attach attach) {
		Tattach t = attachDao.get(Tattach.class, attach.getId());
		if (t != null) {
			MyBeanUtils.copyProperties(attach, t, new String[] { "id" , "addtime", "isdeleted","updatetime" },true);
		}
	}

	@Override
	public void delete(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		attachDao.executeHql("update Tattach t set t.isdeleted = 1 where t.id = :id",params);
		//attachDao.delete(attachDao.get(Tattach.class, id));
	}

}
