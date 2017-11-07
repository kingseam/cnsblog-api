package com.csnblog.api.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class SampleAspect {
    @Before("execution(* com.csnblog.api..*.*(..))")
    public void before(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();

        log.info("call method before :: {}", signature.getName());
    }

    @After("execution(* com.csnblog.api..*.*(..))")
    public void after(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();

        log.info("call method after :: {}", signature.getName());
    }
}
