package com.wanxp.blog.service.impl;

import com.wanxp.blog.dao.LogDaoI;
import com.wanxp.blog.model.Tlog;
import com.wanxp.blog.pageModel.DataGrid;
import com.wanxp.blog.pageModel.Log;
import com.wanxp.blog.pageModel.PageHelper;
import com.wanxp.blog.service.LogServiceI;
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
public class LogServiceImpl extends BaseServiceImpl<Log> implements LogServiceI {

	@Autowired
	private LogDaoI logDao;

	@Override
	public DataGrid dataGrid(Log log, PageHelper ph) {
		List<Log> ol = new ArrayList<Log>();
		String hql = " from Tlog t ";
		DataGrid dg = dataGridQuery(hql, ph, log, logDao);
		@SuppressWarnings("unchecked")
		List<Tlog> l = dg.getRows();
		if (l != null && l.size() > 0) {
			for (Tlog t : l) {
				Log o = new Log();
				BeanUtils.copyProperties(t, o);
				ol.add(o);
			}
		}
		dg.setRows(ol);
		return dg;
	}
	

	protected String whereHql(Log log, Map<String, Object> params) {
		String whereHql = "";	
		if (log != null) {
			whereHql += " where t.isdeleted = 0 ";
			if (!F.empty(log.getTenantId())) {
				whereHql += " and t.tenantId = :tenantId";
				params.put("tenantId", log.getTenantId());
			}		
			if (!F.empty(log.getIsdeleted())) {
				whereHql += " and t.isdeleted = :isdeleted";
				params.put("isdeleted", log.getIsdeleted());
			}		
			if (!F.empty(log.getAction())) {
				whereHql += " and t.action = :action";
				params.put("action", log.getAction());
			}		
			if (!F.empty(log.getData())) {
				whereHql += " and t.data = :data";
				params.put("data", log.getData());
			}		
			if (!F.empty(log.getAuthorId())) {
				whereHql += " and t.authorId = :authorId";
				params.put("authorId", log.getAuthorId());
			}		
			if (!F.empty(log.getIp())) {
				whereHql += " and t.ip = :ip";
				params.put("ip", log.getIp());
			}		
			if (!F.empty(log.getCreated())) {
				whereHql += " and t.created = :created";
				params.put("created", log.getCreated());
			}		
		}	
		return whereHql;
	}

	@Override
	public void add(Log log) {
		Tlog t = new Tlog();
		BeanUtils.copyProperties(log, t);
		//t.setId(jb.absx.UUID.uuid());
		t.setIsdeleted(false);
		logDao.save(t);
	}

	@Override
	public Log get(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Tlog t = logDao.get("from Tlog t  where t.id = :id", params);
		Log o = new Log();
		BeanUtils.copyProperties(t, o);
		return o;
	}

	@Override
	public void edit(Log log) {
		Tlog t = logDao.get(Tlog.class, log.getId());
		if (t != null) {
			MyBeanUtils.copyProperties(log, t, new String[] { "id" , "addtime", "isdeleted","updatetime" },true);
		}
	}

	@Override
	public void delete(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		logDao.executeHql("update Tlog t set t.isdeleted = 1 where t.id = :id",params);
		//logDao.delete(logDao.get(Tlog.class, id));
	}

}
