package com.cnsblog.api.common.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class SampleAspect {
    @Before("execution(* com.csnblog.api..*.*(..))")
    public void before(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();

        log.info("call method before :: {}", signature.getName());
    }


    @Around("within(com.csnblog.api.web.controller.*)")
    public Object logBefore(ProceedingJoinPoint point) throws Throwable {
        ObjectMapper objectMapper = new ObjectMapper();
        Object resultVal = point.proceed();

        long start = System.currentTimeMillis();
        long processTime = System.currentTimeMillis() - start;

        StringBuilder sb = new StringBuilder();
        Object[] params = point.getArgs();

        int i = 0;
        for (Object param : params) {
            if (param != null) {
                if (i > 0) sb.append(", ");
                sb.append(objectMapper.writeValueAsString(param));
                i++;
            }
        }

        log.info("");
        log.info("---------------------------------------------------------------------------------------------------------------------------");
        log.info("Processing Time({}) : {} ms", point.getSignature().toShortString(), processTime);
        log.info("Param : {}", sb.toString());
        log.info("Result : {}", objectMapper.writeValueAsString(resultVal));
        log.info("---------------------------------------------------------------------------------------------------------------------------");

        return resultVal;
    }

    @After("execution(* com.csnblog.api..*.*(..))")
    public void after(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();

        log.info("call method after :: {}", signature.getName());
    }
}
