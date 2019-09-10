package com.star.service.Impl;

import com.star.mapper.LoginMapper;
import com.star.service.LoginService;
import com.star.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl  implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User findByName(String name) {

        return loginMapper.findByName(name);
    }
}
