package com.example.rest;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.annotation.Log;
/**
 * @author DiiD
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/lists")
    @Log("获取用户列表")
    public ResponseEntity<Object> getListUser() {
        return new ResponseEntity<>(userService.getUserList(), HttpStatus.OK);
    }
}
