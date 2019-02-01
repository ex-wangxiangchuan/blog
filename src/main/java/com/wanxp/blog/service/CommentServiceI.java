package com.wanxp.blog.service;

import com.wanxp.blog.model.dto.CommentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 
 * @author John
 * 
 */
public interface CommentServiceI {


	/**
	 * 获取Comment数据表格
	 *
	 * @param pa
	 *            分页帮助类
	 * @return
	 */
	public Page queryInPage(Pageable pa);

	/**
	 * 获取Comment数据表格
	 * 
	 * @param comment
	 *            参数
	 * @param pa
	 *            分页帮助类
	 * @return
	 */
	public Page queryInPage(CommentDTO comment, Pageable pa);

	/**
	 * 添加Comment
	 * 
	 * @param comment
	 */
	public void add(CommentDTO comment);

	/**
	 * 获得Comment对象
	 * 
	 * @param id
	 * @return
	 */
	public CommentDTO get(Integer id);

	/**
	 * 修改Comment
	 * 
	 * @param comment
	 */
	public void edit(CommentDTO comment);

	/**
	 * 删除Comment
	 * 
	 * @param id
	 */
	public void delete(Integer id);

}
