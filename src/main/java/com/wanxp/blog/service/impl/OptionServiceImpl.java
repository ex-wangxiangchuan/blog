package com.wanxp.blog.service.impl;

import com.wanxp.blog.dao.OptionDaoI;
import com.wanxp.blog.model.Toption;
import com.wanxp.blog.pageModel.DataGrid;
import com.wanxp.blog.pageModel.Option;
import com.wanxp.blog.pageModel.PageHelper;
import com.wanxp.blog.service.OptionServiceI;
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
public class OptionServiceImpl extends BaseServiceImpl<Option> implements OptionServiceI {

	@Autowired
	private OptionDaoI optionDao;

	@Override
	public DataGrid dataGrid(Option option, PageHelper ph) {
		List<Option> ol = new ArrayList<Option>();
		String hql = " from Toption t ";
		DataGrid dg = dataGridQuery(hql, ph, option, optionDao);
		@SuppressWarnings("unchecked")
		List<Toption> l = dg.getRows();
		if (l != null && l.size() > 0) {
			for (Toption t : l) {
				Option o = new Option();
				BeanUtils.copyProperties(t, o);
				ol.add(o);
			}
		}
		dg.setRows(ol);
		return dg;
	}
	

	protected String whereHql(Option option, Map<String, Object> params) {
		String whereHql = "";	
		if (option != null) {
			whereHql += " where t.isdeleted = 0 ";
			if (!F.empty(option.getTenantId())) {
				whereHql += " and t.tenantId = :tenantId";
				params.put("tenantId", option.getTenantId());
			}		
			if (!F.empty(option.getIsdeleted())) {
				whereHql += " and t.isdeleted = :isdeleted";
				params.put("isdeleted", option.getIsdeleted());
			}		
			if (!F.empty(option.getName())) {
				whereHql += " and t.name = :name";
				params.put("name", option.getName());
			}		
			if (!F.empty(option.getValue())) {
				whereHql += " and t.value = :value";
				params.put("value", option.getValue());
			}		
			if (!F.empty(option.getDescription())) {
				whereHql += " and t.description = :description";
				params.put("description", option.getDescription());
			}		
		}	
		return whereHql;
	}

	@Override
	public void add(Option option) {
		Toption t = new Toption();
		BeanUtils.copyProperties(option, t);
		//t.setId(jb.absx.UUID.uuid());
		t.setIsdeleted(false);
		optionDao.save(t);
	}

	@Override
	public Option get(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Toption t = optionDao.get("from Toption t  where t.id = :id", params);
		Option o = new Option();
		BeanUtils.copyProperties(t, o);
		return o;
	}

	@Override
	public void edit(Option option) {
		Toption t = optionDao.get(Toption.class, option.getId());
		if (t != null) {
			MyBeanUtils.copyProperties(option, t, new String[] { "id" , "addtime", "isdeleted","updatetime" },true);
		}
	}

	@Override
	public void delete(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		optionDao.executeHql("update Toption t set t.isdeleted = 1 where t.id = :id",params);
		//optionDao.delete(optionDao.get(Toption.class, id));
	}

}
