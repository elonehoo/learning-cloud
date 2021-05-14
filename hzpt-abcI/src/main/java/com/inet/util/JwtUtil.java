package com.inet.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Map;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/5/11 14:20
 */
public class JwtUtil {
    /**
     * Jwt加密公钥
     */
    private final static Key KEY = new SecretKeySpec(
            "asdfasdfasdfasdfasdfasdfasdfasdf".getBytes(StandardCharsets.UTF_8),
            "HS256");

    /**
     * 获取Jwt的荷载
     *
     * @param token JwtToken
     */
    public static Map<String, Object> getClaims(String token) {
        return (Claims) Jwts.parserBuilder().setSigningKey(KEY).build().parse(token).getBody();
    }
}