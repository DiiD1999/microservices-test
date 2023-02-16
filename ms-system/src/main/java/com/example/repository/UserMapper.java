package com.example.repository;


import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author DiiD
 */
@Mapper
@Repository
public interface UserMapper {

    List<User> getUserList();

    /**
     * 批量添加新增用户
     *
     * @param userList
     * @return
     */
    public int batchUser(List<User> userList);
}
