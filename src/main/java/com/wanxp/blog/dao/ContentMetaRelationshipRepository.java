package com.wanxp.blog.dao;

import com.wanxp.blog.model.ContentMetaRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ContentMetaRelationship数据库操作类
 * 
 * @author John
 * 
 */
public interface ContentMetaRelationshipRepository extends JpaRepository<ContentMetaRelationship, Integer> {

}
