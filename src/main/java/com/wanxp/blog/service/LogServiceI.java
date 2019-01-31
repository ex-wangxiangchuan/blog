package com.wanxp.blog.service;

import com.wanxp.blog.model.dto.LogDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 
 * @author John
 * 
 */
public interface LogServiceI {

	/**
	 * 获取Log数据表格
	 * 
	 * @param log
	 *            参数
	 * @param pa
	 *            分页帮助类
	 * @return
	 */
	public Page queryInPage(LogDTO log, Pageable pa);

	/**
	 * 添加Log
	 * 
	 * @param log
	 */
	public void add(LogDTO log);

	/**
	 * 获得Log对象
	 * 
	 * @param id
	 * @return
	 */
	public LogDTO get(Integer id);

	/**
	 * 修改Log
	 * 
	 * @param log
	 */
	public void edit(LogDTO log);

	/**
	 * 删除Log
	 * 
	 * @param id
	 */
	public void delete(Integer id);

}
