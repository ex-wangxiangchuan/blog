package com.wanxp.blog.interceptor;

import com.wanxp.blog.pageModel.SessionInfo;
import com.wanxp.blog.service.impl.RedisUserServiceImpl;
import com.wanxp.blog.util.F;
import com.wanxp.blog.util.UUID;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TokenManage {

    public static String TOKEN_FIELD = "tokenId";

    private ConcurrentHashMap<String, TokenWrap> tokenMap = new ConcurrentHashMap<String, TokenWrap>();

    public static String DEFAULT_TOKEN = "89";
    /**
     * 数据源回收，空闲期
     */
    private long freeTime = 1000 * 60 * 60 * 24;

    /**
     * 开启redis token管理
     */
    protected boolean enableRedis = true;

    @Resource
    private RedisUserServiceImpl redisUserService;

    public void init() {
        /*new Thread("token 回收") {
            public void run() {
                while (true) {
                    try {
                        sleep(10 * 1000);
                        try {
                            collection();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        }.start();*/
    }

    public boolean validToken(String tid) {
        if (TokenManage.DEFAULT_TOKEN.equals(tid)) return true;

        boolean flag = redisUserService.getToken(tid) == null ? false : true;
        if (flag) redisUserService.refresh(tid);
        return flag;
    }

    public SessionInfo getSessionInfo(String tokenId) {
        if (F.empty(tokenId)) return null;
        TokenWrap token;
        if (enableRedis) {
            if (TokenManage.DEFAULT_TOKEN.equals(tokenId)) {
                token = new TokenWrap(tokenId, DEFAULT_TOKEN, "测试超级管理员", this, 7);

            } else {
                token = redisUserService.getToken(tokenId);
            }
        } else {
            token = tokenMap.get(tokenId);
        }
        if (token == null) return null;
        SessionInfo s = new SessionInfo();
        s.setId(token.getUid());
        s.setName(token.getName());
        return s;
    }

    public String getName(String tokenId) {
        SessionInfo sessionInfo = getSessionInfo(tokenId);
        return sessionInfo == null ? null : sessionInfo.getName();
    }

    public String getUid(String tokenId) {
        SessionInfo sessionInfo = getSessionInfo(tokenId);
        return sessionInfo == null ? null : sessionInfo.getId();
    }

    public SessionInfo getSessionInfo(HttpServletRequest request) {
        String tokenId = request.getParameter(TokenManage.TOKEN_FIELD);
        return getSessionInfo(tokenId);
    }

    public String getUid(HttpServletRequest request) {
        SessionInfo sessionInfo = getSessionInfo(request);
        return sessionInfo == null ? null : sessionInfo.getId();
    }


    private void initDefaultToken() {
        TokenWrap wrap = new TokenWrap(DEFAULT_TOKEN, DEFAULT_TOKEN, "测试管理员", this, null);
        wrap.retime();
        tokenMap.putIfAbsent(DEFAULT_TOKEN, wrap);

    }

    /**
     * 通过userId销毁Radis中的Token以及Token关系
     *
     * @param uid
     * @return
     */
    public boolean destroyTokenByMbUserId(String uid) {
        if (enableRedis) {
            return redisUserService.deleteTokenByUid(uid);
        }
        return false;
    }

    public String buildToken(String uid, String name, Integer shopId) {
        String tokenId = UUID.uuid();
        TokenWrap wrap = new TokenWrap(tokenId, uid, name, this, shopId);
        if (enableRedis) {
            redisUserService.setToken(wrap);
        } else {
            wrap.retime();
            tokenMap.putIfAbsent(tokenId, wrap);
        }
        return tokenId;
    }

    public void refreshRedisToken(String token) {
        redisUserService.refresh(token);
    }

    public static TokenManage getTokenManage() {
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        return wac.getBean(TokenManage.class);
    }

    /**
     * 回收空闲数据源
     */
    private void collection() {
        synchronized (TokenManage.class) {
            long ntime = System.currentTimeMillis();
            Iterator<String> iter = tokenMap.keySet().iterator();
            String key = null;
            TokenWrap ds = null;
            while (iter.hasNext()) {
                key = iter.next();
                ds = tokenMap.get(key);
                if (ds != null) {
                    if (ntime - ds.getCtime() > freeTime) {
                        if (key.equals(DEFAULT_TOKEN)) continue;
                        tokenMap.remove(key);
                        iter.remove();
                    }
                }
            }
        }
    }
}
