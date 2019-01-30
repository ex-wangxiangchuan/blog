package com.wanxp.blog.dao;

import com.wanxp.blog.model.Meta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Meta数据库操作类
 * 
 * @author John
 * 
 */
public interface MetaRepository extends JpaRepository<Meta, Integer> {

}
