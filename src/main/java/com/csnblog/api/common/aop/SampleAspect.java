package com.csnblog.api.common.aop;

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
    public void before(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();

        log.info("call method before :: {}", signature.getName());
    }


    @Around("within(com.csnblog.api.web.controller.*)")
    public Object logBefore(ProceedingJoinPoint point) throws Throwable {

        long start = System.currentTimeMillis();
        Object resultVal = point.proceed();
        long processTime = System.currentTimeMillis() - start;

        StringBuilder sb = new StringBuilder();
        Object[] params = point.getArgs();

        int i=0;
        for(Object param : params) {
            if(param != null) {
                if(i > 0)	sb.append(", ");
                sb.append(param.toString());
                i++;
            }
        }

        log.info("");
        log.info("---------------------------------------------------------------------------------------------------------------------------");
        log.info("Processing Time({}) : {} ms", point.getSignature().toShortString(), processTime);
        log.info("Param : {}", sb.toString());
        log.info("Result : {}", resultVal.toString());
        log.info("---------------------------------------------------------------------------------------------------------------------------");

        return resultVal;
    }

    @After("execution(* com.csnblog.api..*.*(..))")
    public void after(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();

        log.info("call method after :: {}", signature.getName());
    }
}
