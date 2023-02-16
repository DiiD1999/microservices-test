package com.example.service;

import com.example.entity.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;

/**
 * @author DiiD
 */
public interface LogService {

    @Async
    public void save(String username, String browser, String ip, ProceedingJoinPoint joinPoint, Log log);

}
