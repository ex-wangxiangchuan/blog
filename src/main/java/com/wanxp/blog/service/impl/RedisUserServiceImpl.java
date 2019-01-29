package com.wanxp.blog.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wanxp.blog.interceptor.TokenWrap;
import com.wanxp.blog.util.F;
import org.springframework.stereotype.Service;

@Service(value = "redisUserService")
public class RedisUserServiceImpl {
    public boolean setToken(TokenWrap tokenWrap) {
//        redisUtil.set(buildKey(tokenWrap.getTokenId()), JSONObject.toJSONString(tokenWrap), timeout, TimeUnit.SECONDS);
//        //USER_USERID_TOKEN
//        redisUtil.set(Key.build(Namespace.USER_USERID_TOKEN, tokenWrap.getUid()), tokenWrap.getTokenId());
        return true;
    }
    public TokenWrap getToken(String token) {
//        String json = (String) redisUtil.get(buildKey(token));
        String json = "";
        if (F.empty(json)) return null;
        return JSONObject.parseObject(json, TokenWrap.class);
    }
    /**
     * 刷新token
     *
     * @param token
     */
    public void refresh(String token) {
//        redisUtil.expire(buildKey(token), timeout, TimeUnit.SECONDS);
    }

    /**
     * 删除存在Radis中存放的用户的Token键值对
     *
     * @param uid
     * @return
     */
    public boolean deleteTokenByUid(String uid) {
//        //通过Key.build方法传入的两个参数获取存入Radis中存放的userId的key值
//        String uidKey = Key.build(Namespace.USER_USERID_TOKEN, uid);
//        //通过已经存放的userIdkey值找到Radis中对应关系的tokenIdKey
//        String tokenIdKey = (String) redisUtil.get(uidKey);
//        //删除tokenIdKey键值对(Radis存放的是tokenIdKey和对应的mbUser的信息TokenWrap对象)
//        if (tokenIdKey != null)
//            redisUtil.delete(buildKey(tokenIdKey));
//        //删除userIdKey键值对(Radis存放的是userIdkey与对应的tokenIdKey)
//        if (uidKey != null)
//            redisUtil.delete(uidKey);
        return true;
    }
}
