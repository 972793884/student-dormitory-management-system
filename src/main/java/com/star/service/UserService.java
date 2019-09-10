package com.star.service;

import com.star.vo.User;

import java.util.List;

public interface UserService {
    Integer save(User user);

    List<User> getUserList();
}
