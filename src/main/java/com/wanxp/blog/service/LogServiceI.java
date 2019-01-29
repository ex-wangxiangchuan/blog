package com.wanxp.blog.service;

import com.wanxp.blog.pageModel.DataGrid;
import com.wanxp.blog.pageModel.Log;
import com.wanxp.blog.pageModel.PageHelper;

/**
 * 
 * @author John
 * 
 */
public interface LogServiceI {

	/**
	 * 获取Log数据表格
	 * 
	 * @param log
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @return
	 */
	public DataGrid dataGrid(Log log, PageHelper ph);

	/**
	 * 添加Log
	 * 
	 * @param log
	 */
	public void add(Log log);

	/**
	 * 获得Log对象
	 * 
	 * @param id
	 * @return
	 */
	public Log get(Integer id);

	/**
	 * 修改Log
	 * 
	 * @param log
	 */
	public void edit(Log log);

	/**
	 * 删除Log
	 * 
	 * @param id
	 */
	public void delete(Integer id);

}
