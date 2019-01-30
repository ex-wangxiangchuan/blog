package com.wanxp.blog.service;

import com.wanxp.blog.dto.AttachDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
	 * @param pa
	 *            分页帮助类
	 * @return
	 */
	public Page queryInPage(AttachDTO attach, Pageable pa);

	/**
	 * 添加Attach
	 * 
	 * @param attach
	 */
	public void add(AttachDTO attach);

	/**
	 * 获得Attach对象
	 * 
	 * @param id
	 * @return
	 */
	public AttachDTO get(Integer id);

	/**
	 * 修改Attach
	 * 
	 * @param attach
	 */
	public void edit(AttachDTO attach);

	/**
	 * 删除Attach
	 * 
	 * @param id
	 */
	public void delete(Integer id);

}
