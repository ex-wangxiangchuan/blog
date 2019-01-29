package com.wanxp.blog.service;

import com.wanxp.blog.pageModel.DataGrid;
import com.wanxp.blog.pageModel.PageHelper;
import com.wanxp.blog.pageModel.User;

/**
 * 
 * @author John
 * 
 */
public interface UserServiceI {

	/**
	 * 获取User数据表格
	 * 
	 * @param user
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @return
	 */
	public DataGrid dataGrid(User user, PageHelper ph);

	/**
	 * 添加User
	 * 
	 * @param user
	 */
	public void add(User user);

	/**
	 * 获得User对象
	 * 
	 * @param id
	 * @return
	 */
	public User get(Integer id);

	/**
	 * 修改User
	 * 
	 * @param user
	 */
	public void edit(User user);

	/**
	 * 删除User
	 * 
	 * @param id
	 */
	public void delete(Integer id);

}
