package com.star.service.Impl;

import com.star.service.UserService;
import com.star.mapper.UserMapper;
import com.star.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public Integer save(User user) {
        if (user.getId()==null){
            user.setSignInTime(new Date());
            user.setIsDelete(1);
            return userMapper.save(user);
        } else{
            //user=userMapper.findById(user.getId());
            return userMapper.update(user);
        }

    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }
}
