package com.wanxp.blog.service;

import com.wanxp.blog.dto.MetaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
	 * @param pa
	 *            分页帮助类
	 * @return
	 */
	public Page queryInPage(MetaDTO meta, Pageable pa);

	/**
	 * 添加Meta
	 * 
	 * @param meta
	 */
	public void add(MetaDTO meta);

	/**
	 * 获得Meta对象
	 * 
	 * @param id
	 * @return
	 */
	public MetaDTO get(Integer id);

	/**
	 * 修改Meta
	 * 
	 * @param meta
	 */
	public void edit(MetaDTO meta);

	/**
	 * 删除Meta
	 * 
	 * @param id
	 */
	public void delete(Integer id);

}
