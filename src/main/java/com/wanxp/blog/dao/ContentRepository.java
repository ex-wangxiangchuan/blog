package com.wanxp.blog.dao;

import com.wanxp.blog.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Content数据库操作类
 * 
 * @author John
 * 
 */
@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {

}
