package com.example.aspect;

import com.example.entity.Log;
import com.example.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author DiiD
 */
// todo Aspect 表示这是一个注解吗？
@Component
@Aspect
@Slf4j
public class LogAspect {

    private final LogService logService;
    ThreadLocal<Long> currentTime = new ThreadLocal<>();
    public LogAspect(LogService logService) {
        this.logService = logService;
    }
    @Pointcut("@annotation(com.example.annotation.Log))")
    public void logPointcut(){

    }

    @Around("logPointcut()")
    public Object logAroud(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result;
        currentTime.set(System.currentTimeMillis());
        // todo proceed这个方法的意义是什么？
        result = joinPoint.proceed();
        Log log = new Log("INFO", System.currentTimeMillis() - currentTime.get());
        currentTime.remove();
        HttpServletRequest request =  ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        logService.save("user", "Chrome 8", "127.0.0.1", joinPoint, log);
        return result;
    }




}
