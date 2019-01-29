package com.wanxp.blog.service;

import com.wanxp.blog.pageModel.ContentMetaRelationship;
import com.wanxp.blog.pageModel.DataGrid;
import com.wanxp.blog.pageModel.PageHelper;

/**
 * 
 * @author John
 * 
 */
public interface ContentMetaRelationshipServiceI {

	/**
	 * 获取ContentMetaRelationship数据表格
	 * 
	 * @param contentMetaRelationship
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @return
	 */
	public DataGrid dataGrid(ContentMetaRelationship contentMetaRelationship, PageHelper ph);

	/**
	 * 添加ContentMetaRelationship
	 * 
	 * @param contentMetaRelationship
	 */
	public void add(ContentMetaRelationship contentMetaRelationship);

	/**
	 * 获得ContentMetaRelationship对象
	 * 
	 * @param id
	 * @return
	 */
	public ContentMetaRelationship get(Integer id);

	/**
	 * 修改ContentMetaRelationship
	 * 
	 * @param contentMetaRelationship
	 */
	public void edit(ContentMetaRelationship contentMetaRelationship);

	/**
	 * 删除ContentMetaRelationship
	 * 
	 * @param id
	 */
	public void delete(Integer id);

}
