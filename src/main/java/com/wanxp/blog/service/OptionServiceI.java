package com.wanxp.blog.service;

import com.wanxp.blog.pageModel.DataGrid;
import com.wanxp.blog.pageModel.Option;
import com.wanxp.blog.pageModel.PageHelper;

/**
 * 
 * @author John
 * 
 */
public interface OptionServiceI {

	/**
	 * 获取Option数据表格
	 * 
	 * @param option
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @return
	 */
	public DataGrid dataGrid(Option option, PageHelper ph);

	/**
	 * 添加Option
	 * 
	 * @param option
	 */
	public void add(Option option);

	/**
	 * 获得Option对象
	 * 
	 * @param id
	 * @return
	 */
	public Option get(Integer id);

	/**
	 * 修改Option
	 * 
	 * @param option
	 */
	public void edit(Option option);

	/**
	 * 删除Option
	 * 
	 * @param id
	 */
	public void delete(Integer id);

}
