package com.wanxp.blog.service;

import com.wanxp.blog.dto.ContentMetaRelationshipDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
	 * @param pa
	 *            分页帮助类
	 * @return
	 */
	public Page queryInPage(ContentMetaRelationshipDTO contentMetaRelationship, Pageable pa);

	/**
	 * 添加ContentMetaRelationship
	 * 
	 * @param contentMetaRelationship
	 */
	public void add(ContentMetaRelationshipDTO contentMetaRelationship);

	/**
	 * 获得ContentMetaRelationship对象
	 * 
	 * @param id
	 * @return
	 */
	public ContentMetaRelationshipDTO get(Integer id);

	/**
	 * 修改ContentMetaRelationship
	 * 
	 * @param contentMetaRelationship
	 */
	public void edit(ContentMetaRelationshipDTO contentMetaRelationship);

	/**
	 * 删除ContentMetaRelationship
	 * 
	 * @param id
	 */
	public void delete(Integer id);

}
