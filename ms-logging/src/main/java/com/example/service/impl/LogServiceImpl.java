package com.example.service.impl;

import com.example.entity.Log;
import com.example.repository.LogMapper;
import com.example.service.LogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DiiD
 */
@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {

    private static final Logger log = LoggerFactory.getLogger(LogServiceImpl.class);
    private final LogMapper logMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(String username, String browser, String ip, ProceedingJoinPoint joinPoint, Log log) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        com.example.annotation.Log aopLog = method.getAnnotation(com.example.annotation.Log.class);

        // 方法路径
        String methodName = joinPoint.getTarget().getClass() + "." + signature.getName() + "()";

        if (log != null) {
            log.setDescription(aopLog.value());
        }

        assert log != null;
        log.setRequestIp(ip);
        log.setAddress("内网IP");
        log.setMethod(methodName);
        log.setUsername(username);
        String tmp = "{{username=admin, password= ******} SecurityContextHolderAwareRequestWrapper[ FirewalledRequest[ org.apache.catalina.connector.RequestFacade@4597b1b6]]  }";
        log.setParams(tmp);
        log.setBrowser(browser);
        logMapper.save(log);
    }

    /**
     * 根据方法和传入的参数获取请求参数
     */
//    private String getParameter(Method method, Object[] args) {
//        List<Object> argList = new ArrayList<>();
//        Parameter[] parameters = method.getParameters();
//        for (int i = 0; i < parameters.length; i++) {
//            //将RequestBody注解修饰的参数作为请求参数
//            RequestBody requestBody = parameters[i].getAnnotation(RequestBody.class);
//            if (requestBody != null) {
//                argList.add(args[i]);
//            }
//            //将RequestParam注解修饰的参数作为请求参数
//            RequestParam requestParam = parameters[i].getAnnotation(RequestParam.class);
//            if (requestParam != null) {
//                Map<String, Object> map = new HashMap<>();
//                String key = parameters[i].getName();
//                if (!StringUtils.isEmpty(requestParam.value())) {
//                    key = requestParam.value();
//                }
//                map.put(key, args[i]);
//                argList.add(map);
//            }
//        }
//        if (argList.size() == 0) {
//            return "";
//        }
//        return argList.size() == 1 ? JSONUtil.toJsonStr(argList.get(0)) : JSONUtil.toJsonStr(argList);
//    }
}
