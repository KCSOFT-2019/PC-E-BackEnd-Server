package com.xuste.service;


import com.xuste.pojo.User;

public interface TokenService {
    String getToken(long userNumber);
}
