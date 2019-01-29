package com.wanxp.blog.service;

import com.wanxp.blog.pageModel.Comment;
import com.wanxp.blog.pageModel.DataGrid;
import com.wanxp.blog.pageModel.PageHelper;

/**
 * 
 * @author John
 * 
 */
public interface CommentServiceI {

	/**
	 * 获取Comment数据表格
	 * 
	 * @param comment
	 *            参数
	 * @param ph
	 *            分页帮助类
	 * @return
	 */
	public DataGrid dataGrid(Comment comment, PageHelper ph);

	/**
	 * 添加Comment
	 * 
	 * @param comment
	 */
	public void add(Comment comment);

	/**
	 * 获得Comment对象
	 * 
	 * @param id
	 * @return
	 */
	public Comment get(Integer id);

	/**
	 * 修改Comment
	 * 
	 * @param comment
	 */
	public void edit(Comment comment);

	/**
	 * 删除Comment
	 * 
	 * @param id
	 */
	public void delete(Integer id);

}
