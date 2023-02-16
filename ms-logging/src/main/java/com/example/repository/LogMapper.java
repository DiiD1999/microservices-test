package com.example.repository;

import com.example.entity.Log;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author DiiD
 */
@Mapper
@Repository
public interface LogMapper {

    public void save(Log log);
}
