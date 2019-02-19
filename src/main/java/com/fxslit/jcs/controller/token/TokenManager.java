package com.fxslit.jcs.controller.token;

import com.alibaba.fastjson.JSON;
import com.fxslit.common.util.GetTime;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

/**
 * @program: jieqd
 * @description: token管理
 * @author: Losn
 * @create: 2018-05-23 16:15
 **/
public class TokenManager {
    /**
     * key : 用户ID
     */
    private static Logger logger = LoggerFactory.getLogger(TokenManager.class);

    private static String code(){
        return "123456";
    }
    private static int LOGIN_ERROR = 403;
    private static int EXPIRES_IN = 7200;
    private static final String SECRET_KEY = "jieqd";
    private static String builder(String str){
        String code = null;
        try{
            code = Jwts.builder().setSubject(str).signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
        }catch (Exception e){
            logger.info("加密失败"+e.toString());
        }
        return code;
    }
    private static String parser(String code){
        String str = null;
        try {
            str = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(code).getBody().getSubject();
        } catch (MalformedJwtException e){
            logger.info("解密失败"+e.toString());
        }
        return str;
    }
    /**
     * 制作过程中 增加当天服务器时间为验证项目
     * @return
     */
    public static String write(int uid){
        Token token = new Token();
        token.setUid(uid);
        token.setTimestamp(GetTime.getTimestamp());
        token.setExpires_in(7200);
        token.setCode(code());

        String json = JSON.toJSONString(token);
        String tokenStr = builder(json);
        if(tokenStr!=null){
            return "Bearer "+tokenStr;
        }else {
            logger.info("生成token失败");
            return null;
        }

    }
    /**
     * 生成测试token
     * @return
     */
    public static String writeTokenStatic(){
        Token token = new Token();
        token.setExpires_in(72000000);
        token.setUid(1);
        token.setTimestamp(GetTime.getTimestamp());
        token.setCode(code());
        String json = JSON.toJSONString(token);
        String tokenStr = Jwts.builder().setSubject(json).signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
        System.out.println(json);
        System.out.println("Bearer "+tokenStr);
        System.out.println();
        return tokenStr;
    }

    public static boolean check(HttpHeaders headers){
        String tokenStr = headers.getFirst("Authorization");
        return check(tokenStr);
    }
    public static boolean check(String tokenStr){
        if(tokenStr!=null&& tokenStr .length()>10){
            tokenStr = tokenStr.replaceAll("Bearer ", "");
            String json = parser(tokenStr);
            if(json!=null&&json.length()>0){
                Token token = JSON.parseObject(json, Token.class);
                if(token!=null){

                    return true;
                }else{
                    logger.info("解析tokenJSON失败"+json);
                    return false;
                }
            }else{
                logger.info("解密失败"+tokenStr);
                return false;
            }
        }else{
            logger.info("获取header失败"+tokenStr);
            return false;
        }
    }
    public static int getKey(HttpHeaders headers) {
        String tokenStr = headers.getFirst("Authorization");
        tokenStr = tokenStr.replaceAll("Bearer ", "");
        String json = parser(tokenStr);
        Token token = JSON.parseObject(json, Token.class);
        return token.getUid();
    }
    public static void main(String[] args) {
        System.out.println(writeTokenStatic());
    }
}
