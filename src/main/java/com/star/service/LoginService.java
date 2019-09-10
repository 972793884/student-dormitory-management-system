package com.star.service;

import com.star.vo.User;

public interface LoginService {
    User findByName(String name);
}
