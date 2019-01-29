package com.wanxp.blog.interceptor;

/**
 * Created by john on 16/1/10.
 */
public class TokenWrap implements java.io.Serializable{
    private String tokenId;
    private String name;
    private String uid;
    private String serverHost;
    private long ctime;//上一次使用时间
    private TokenManage tokenManage;
    private Integer shopId;

    public TokenWrap() {
    }

    public TokenWrap(String tokenId, String uid, String name, TokenManage tokenManage, Integer shopId){
        this.tokenId = tokenId;
        this.uid = uid;
        this.name = name;
        this.tokenManage =tokenManage;
        this.shopId =shopId;
    }
    public void retime(){
        if(tokenManage == null){
            tokenManage = TokenManage.getTokenManage();
        }
        if (tokenManage != null && tokenManage.enableRedis) {
            tokenManage.refreshRedisToken(tokenId);
        } else {
            ctime = System.currentTimeMillis();
        }
    }
    public String getTokenId() {
        return tokenId;
    }
    public long getCtime() {
        return ctime;
    }
    public String getName() {
        return name;
    }
    public String getUid() {
        return uid;
    }

    public String getServerHost() {
        return serverHost;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setCtime(long ctime) {
        this.ctime = ctime;
    }

    public TokenManage getTokenManage() {
        return tokenManage;
    }

    public void setTokenManage(TokenManage tokenManage) {
        this.tokenManage = tokenManage;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

}