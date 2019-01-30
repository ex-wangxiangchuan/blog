package com.wanxp.blog.service;

import com.wanxp.blog.dto.ContentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
	 * @param pa
	 *            分页帮助类
	 * @return
	 */
	public Page queryInPage(ContentDTO content, Pageable pa);

	/**
	 * 添加Content
	 * 
	 * @param content
	 */
	public void add(ContentDTO content);

	/**
	 * 获得Content对象
	 * 
	 * @param id
	 * @return
	 */
	public ContentDTO get(Integer id);

	/**
	 * 修改Content
	 * 
	 * @param content
	 */
	public void edit(ContentDTO content);

	/**
	 * 删除Content
	 * 
	 * @param id
	 */
	public void delete(Integer id);

}
