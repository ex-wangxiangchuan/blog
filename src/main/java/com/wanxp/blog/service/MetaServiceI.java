package com.wanxp.blog.service;

import com.wanxp.blog.pageModel.DataGrid;
import com.wanxp.blog.pageModel.Meta;
import com.wanxp.blog.pageModel.PageHelper;

/**
 * 
 * @author John
 * 
 */
public interface MetaServiceI {

	/**
	 * 获取Meta数据表格
	 * 
	 * @param meta
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @return
	 */
	public DataGrid dataGrid(Meta meta, PageHelper ph);

	/**
	 * 添加Meta
	 * 
	 * @param meta
	 */
	public void add(Meta meta);

	/**
	 * 获得Meta对象
	 * 
	 * @param id
	 * @return
	 */
	public Meta get(Integer id);

	/**
	 * 修改Meta
	 * 
	 * @param meta
	 */
	public void edit(Meta meta);

	/**
	 * 删除Meta
	 * 
	 * @param id
	 */
	public void delete(Integer id);

}
