package com.wanxp.blog.service;

import com.wanxp.blog.model.dto.OptionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
	 * @param pa
	 *            分页帮助类
	 * @return
	 */
	public Page queryInPage(OptionDTO option, Pageable pa);

	/**
	 * 添加Option
	 * 
	 * @param option
	 */
	public void add(OptionDTO option);

	/**
	 * 获得Option对象
	 * 
	 * @param id
	 * @return
	 */
	public OptionDTO get(Integer id);

	/**
	 * 修改Option
	 * 
	 * @param option
	 */
	public void edit(OptionDTO option);

	/**
	 * 删除Option
	 * 
	 * @param id
	 */
	public void delete(Integer id);

}
