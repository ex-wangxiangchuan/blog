package com.wanxp.blog;

import com.alibaba.fastjson.JSONObject;
import com.wanxp.blog.model.Attach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Test
    public void contextLoads() {
        Attach attach = new Attach();
        attach.setAddtime(new Date());
        attach.setAuthorId(11);
        attach.setCreated(11);
        attach.setFkey("234");
        attach.setFname("what");
        attach.setFtype("sss");
        attach.setId(11);
        attach.setIsdeleted(false);
        attach.setTenantId(22);
        attach.setUpdatetime(new Date());
        for (int i = 1; i < 100;i++) {
            System.err.println(JSONObject.toJSONString(attach));
        }
    }

}

