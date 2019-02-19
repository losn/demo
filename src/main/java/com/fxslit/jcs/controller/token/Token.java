package com.fxslit.jcs.controller.token;

/**
 * @program: jieqd
 * @description: token
 * @author: Losn
 * @create: 2018-05-23 16:15
 **/
public class Token {
    /**
     * expires_in : 过期时间
     * timestamp : 颁发时间
     * code : 随机码
     */
    private int uid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private int expires_in;
    private long timestamp;
    private String code;

    @Override
    public String toString() {
        return "Token{" +
                "uid=" + uid +
                ", expires_in=" + expires_in +
                ", timestamp=" + timestamp +
                ", code='" + code + '\'' +
                '}';
    }
}
