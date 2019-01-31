package com.wanxp.blog;

import com.alibaba.fastjson.JSONObject;
import com.wanxp.blog.dao.ContentRepository;
import com.wanxp.blog.model.Attach;
import com.wanxp.blog.model.Content;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Autowired
    private ContentRepository repository;

    @Test
    public void contextLoads() {
        Content content = new Content();
        content.setId(11);
        content.setTenantId(99);
        content.setAddtime(new Date());
        content.setUpdatetime(new Date());
        content.setIsdeleted(false);
        content.setTitle("文章标题1:奔跑的猪");
        content.setSlug("slug");
        content.setThumbImg("");
        content.setCreated(11);
        content.setModified(11);
        content.setContent("在太阳还未升起的那一刻,地球转不动了");
        content.setAuthorId(11);
        content.setType("FILE");
        content.setStatus("status");
        content.setFmtType("fmType");
        content.setTags("PIG,ANI");
        content.setCategories("TEST");
        content.setHits(22);
        content.setCommentsNum(3);
        content.setAllowComment(11);
        content.setAllowPing(11);
        content.setAllowFeed(11);

        for (int i = 1; i < 100;i++) {
            System.err.println(JSONObject.toJSONString(content));
        }
    }

    @Test
    public void testContent() {

        List<Content> contents = repository.findAll(PageRequest.of(0,10)).getContent();
        System.out.println(contents);
    }

}

