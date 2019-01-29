package com.wanxp.blog.service;

import com.wanxp.blog.pageModel.Attach;
import com.wanxp.blog.pageModel.DataGrid;
import com.wanxp.blog.pageModel.PageHelper;

/**
 * 
 * @author John
 * 
 */
public interface AttachServiceI {

	/**
	 * 获取Attach数据表格
	 * 
	 * @param attach
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @return
	 */
	public DataGrid dataGrid(Attach attach, PageHelper ph);

	/**
	 * 添加Attach
	 * 
	 * @param attach
	 */
	public void add(Attach attach);

	/**
	 * 获得Attach对象
	 * 
	 * @param id
	 * @return
	 */
	public Attach get(Integer id);

	/**
	 * 修改Attach
	 * 
	 * @param attach
	 */
	public void edit(Attach attach);

	/**
	 * 删除Attach
	 * 
	 * @param id
	 */
	public void delete(Integer id);

}
