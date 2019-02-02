package com.wanxp.blog;

import com.wanxp.blog.model.dto.CommentDTO;
import com.wanxp.blog.model.dto.ContentDTO;
import com.wanxp.blog.model.vo.CommentVO;
import com.wanxp.blog.model.vo.ContentVO;
import com.wanxp.blog.service.CommentServiceI;
import com.wanxp.blog.service.ContentServiceI;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class BlogApplication {

    @Autowired
    private ContentServiceI contentService;

    @Autowired
    private CommentServiceI commentService;

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

}

