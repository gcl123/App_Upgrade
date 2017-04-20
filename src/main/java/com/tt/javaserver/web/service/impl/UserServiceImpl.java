package com.tt.javaserver.web.service.impl;


import com.tt.javaserver.web.dao.UserMapper;
import com.tt.javaserver.web.vo.User;
import com.tt.javaserver.web.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public int add(User user) {
        return userMapper.add(user);
    }
}
