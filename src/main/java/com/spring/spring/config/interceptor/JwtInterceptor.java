package com.spring.spring.config.interceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.spring.spring.common.Constants;
import com.spring.spring.entity.User;
import com.spring.spring.exception.ServiceException;
import com.spring.spring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        String token = request.getHeader("token");
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        //Token認証を行う
        if(StrUtil.isBlank(token)){
            throw new ServiceException(Constants.CODE_401,"Tokenなし、再登録をお願いします。");
        }

        //Tokenの中のuserIdを取得する
        String userId;
        try{
            userId = JWT.decode(token).getAudience().get(0);
        }
        catch (JWTDecodeException j){
            throw new ServiceException(Constants.CODE_401,"Token検証失敗、再登録をお願いします。");
        }
        User user = userService.getById(userId);
        if(user == null){
            throw new ServiceException(Constants.CODE_401,"ユーザーが存在しておりませんので、再登録をお願いします。");
        }
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token); // 验证token
        } catch (JWTVerificationException e) {
            throw new ServiceException(Constants.CODE_401, "Token検証失敗、再登録をお願いします。");
        }
        return true;
    }

    }
