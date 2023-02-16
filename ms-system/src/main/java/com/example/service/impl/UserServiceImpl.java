package com.example.service.impl;

import com.example.entity.User;
import com.example.repository.UserMapper;
import com.example.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userRepository;

    // todo 构造器注入方式 Spring 会自动根据构造方法会初始化对象值。
    // todo 这个应该是单例模式吧
    public UserServiceImpl(UserMapper userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUserList() {
        return userRepository.getUserList();
    }
}
