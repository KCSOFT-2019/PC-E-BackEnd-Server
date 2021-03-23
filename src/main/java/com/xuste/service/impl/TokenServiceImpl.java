package com.xuste.service.impl;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.xuste.pojo.User;
import com.xuste.service.TokenService;
import org.springframework.stereotype.Service;


@Service
public class TokenServiceImpl implements TokenService {
    @Override
    public String getToken(long userNumber) {
        String token = "";
        //坑 不能直接存密码
        //将学号转换为String存储
        token = JWT.create().withAudience(String.valueOf(userNumber))
                .sign(Algorithm.HMAC256(String.valueOf(userNumber)));

        return token;
    }

    public static long getStuNumber(String token) {
        return Long.parseLong(JWT.decode(token).getAudience().get(0));
    }
}
