package ww.qrtest.mybatisplus.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties("jwt.config")
public class TokenUtil {
    /*
    * 秘钥
    * */
    private String key;
    /*
    * 签名失效时间
    * */
    private Long ttl;

    /*
    * 设置认证token
    *  id:登录用户id
    *  name：登录用户名
    * */
    public String createJwt(String id, String name, Map<String,Object> map){
        //当前时间
        long now = System.currentTimeMillis();
        //失效时间
        long exp = now + ttl;
        //创建jwtBuilder
        JwtBuilder jwtBuilder = Jwts.builder().setId(id).setSubject(name)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, key);
        map.forEach((k,v)->{
            jwtBuilder.claim(k,v);
        });
        //设置失效时间
        jwtBuilder.setExpiration(new Date(exp));
        //创建token
        String token = jwtBuilder.compact();
        return token;
    }

    /*
    * 解析token
    * */
    public Claims praseToken(String token){
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims;
    }
}
