package com.wanxp.blog.service.impl;

import com.wanxp.blog.dao.UserDaoI;
import com.wanxp.blog.model.Tuser;
import com.wanxp.blog.pageModel.DataGrid;
import com.wanxp.blog.pageModel.PageHelper;
import com.wanxp.blog.pageModel.User;
import com.wanxp.blog.service.UserServiceI;
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
public class UserServiceImpl extends BaseServiceImpl<User> implements UserServiceI {

	@Autowired
	private UserDaoI userDao;

	@Override
	public DataGrid dataGrid(User user, PageHelper ph) {
		List<User> ol = new ArrayList<User>();
		String hql = " from Tuser t ";
		DataGrid dg = dataGridQuery(hql, ph, user, userDao);
		@SuppressWarnings("unchecked")
		List<Tuser> l = dg.getRows();
		if (l != null && l.size() > 0) {
			for (Tuser t : l) {
				User o = new User();
				BeanUtils.copyProperties(t, o);
				ol.add(o);
			}
		}
		dg.setRows(ol);
		return dg;
	}
	

	protected String whereHql(User user, Map<String, Object> params) {
		String whereHql = "";	
		if (user != null) {
			whereHql += " where t.isdeleted = 0 ";
			if (!F.empty(user.getTenantId())) {
				whereHql += " and t.tenantId = :tenantId";
				params.put("tenantId", user.getTenantId());
			}		
			if (!F.empty(user.getIsdeleted())) {
				whereHql += " and t.isdeleted = :isdeleted";
				params.put("isdeleted", user.getIsdeleted());
			}		
			if (!F.empty(user.getUsername())) {
				whereHql += " and t.username = :username";
				params.put("username", user.getUsername());
			}		
			if (!F.empty(user.getPassword())) {
				whereHql += " and t.password = :password";
				params.put("password", user.getPassword());
			}		
			if (!F.empty(user.getEmail())) {
				whereHql += " and t.email = :email";
				params.put("email", user.getEmail());
			}		
			if (!F.empty(user.getHomeUrl())) {
				whereHql += " and t.homeUrl = :homeUrl";
				params.put("homeUrl", user.getHomeUrl());
			}		
			if (!F.empty(user.getScreenName())) {
				whereHql += " and t.screenName = :screenName";
				params.put("screenName", user.getScreenName());
			}		
			if (!F.empty(user.getCreated())) {
				whereHql += " and t.created = :created";
				params.put("created", user.getCreated());
			}		
			if (!F.empty(user.getActivated())) {
				whereHql += " and t.activated = :activated";
				params.put("activated", user.getActivated());
			}		
			if (!F.empty(user.getLogged())) {
				whereHql += " and t.logged = :logged";
				params.put("logged", user.getLogged());
			}		
			if (!F.empty(user.getGroupName())) {
				whereHql += " and t.groupName = :groupName";
				params.put("groupName", user.getGroupName());
			}		
		}	
		return whereHql;
	}

	@Override
	public void add(User user) {
		Tuser t = new Tuser();
		BeanUtils.copyProperties(user, t);
		//t.setId(jb.absx.UUID.uuid());
		t.setIsdeleted(false);
		userDao.save(t);
	}

	@Override
	public User get(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Tuser t = userDao.get("from Tuser t  where t.id = :id", params);
		User o = new User();
		BeanUtils.copyProperties(t, o);
		return o;
	}

	@Override
	public void edit(User user) {
		Tuser t = userDao.get(Tuser.class, user.getId());
		if (t != null) {
			MyBeanUtils.copyProperties(user, t, new String[] { "id" , "addtime", "isdeleted","updatetime" },true);
		}
	}

	@Override
	public void delete(Integer id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		userDao.executeHql("update Tuser t set t.isdeleted = 1 where t.id = :id",params);
		//userDao.delete(userDao.get(Tuser.class, id));
	}

}
