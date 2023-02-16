package com.example.service;

import com.example.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DiiD
 */
@Service
public interface UserService {

    List<User> getUserList();
}
