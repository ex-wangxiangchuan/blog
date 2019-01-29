package com.wanxp.blog.service;

import com.wanxp.blog.pageModel.Content;
import com.wanxp.blog.pageModel.DataGrid;
import com.wanxp.blog.pageModel.PageHelper;

/**
 * 
 * @author John
 * 
 */
public interface ContentServiceI {

	/**
	 * 获取Content数据表格
	 * 
	 * @param content
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @return
	 */
	public DataGrid dataGrid(Content content, PageHelper ph);

	/**
	 * 添加Content
	 * 
	 * @param content
	 */
	public void add(Content content);

	/**
	 * 获得Content对象
	 * 
	 * @param id
	 * @return
	 */
	public Content get(Integer id);

	/**
	 * 修改Content
	 * 
	 * @param content
	 */
	public void edit(Content content);

	/**
	 * 删除Content
	 * 
	 * @param id
	 */
	public void delete(Integer id);

}
