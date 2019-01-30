package com.wanxp.blog.dao;

import com.wanxp.blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Comment数据库操作类
 * 
 * @author John
 * 
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
