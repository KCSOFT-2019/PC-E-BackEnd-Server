package com.xuste.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.xuste.exception.token.NullTokenFoundException;
import com.xuste.exception.NullValueFoundException;
import com.xuste.pojo.User;
import com.xuste.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 记得把异常整合在exception里面
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    UserService service;

    /**
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws NullTokenFoundException
     * @throws NullValueFoundException
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws NullTokenFoundException, NullValueFoundException {
        String token = request.getHeader("Authorization");
        if(!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken loginToken = method.getAnnotation(UserLoginToken.class);
            if (loginToken.required()) {
                if (token == null) {
                    throw new NullTokenFoundException();
                }
                // 获取 token 中的 user id
                String userId;
                try {
                    userId = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException j) {
                    throw new RuntimeException("401");
                }
                // id 是否能够对应 user
                long userIdInt = Long.parseLong(userId);
                User user = service.getOneByUserNumber(userIdInt);
                if (user == null) {
                    throw new NullValueFoundException();
                }
                // 验证 token 是否正确
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(String.valueOf(user.getUserNumber()))).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new NullTokenFoundException();
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
