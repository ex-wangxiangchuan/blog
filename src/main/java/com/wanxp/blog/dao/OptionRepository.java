package com.wanxp.blog.dao;

import com.wanxp.blog.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Option数据库操作类
 * 
 * @author John
 * 
 */
public interface OptionRepository extends JpaRepository<Option, Integer> {

}
