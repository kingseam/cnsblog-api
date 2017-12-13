package com.cnsblog.api.common.aop;

import com.cnsblog.api.common.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

@Component
@Aspect
@Slf4j
public class SampleAspect {
    @Before("execution(* com.cnsblog.api..*.*(..))")
    public void before(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();

        log.info("call method before :: {}", signature.getName());
    }


    @Around("within(com.cnsblog.api.web.controller.*)")
    public Object logBefore(ProceedingJoinPoint point) throws Throwable {
        Object resultVal = point.proceed();

        long start = System.currentTimeMillis();
        long processTime = System.currentTimeMillis() - start;

        Object[] params = point.getArgs();

        String paramMessage = Arrays.stream(params)
                .map(JsonUtils::toJson)
                .collect(joining(", "));

        log.info("");
        log.info("---------------------------------------------------------------------------------------------------------------------------");
        log.info("Processing Time({}) : {} ms", point.getSignature().toShortString(), processTime);
        log.info("Param : {}", paramMessage);
        log.info("Result : {}", JsonUtils.toJson(resultVal));
        log.info("---------------------------------------------------------------------------------------------------------------------------");

        return resultVal;
    }

    @After("execution(* com.cnsblog.api..*.*(..))")
    public void after(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();

        log.info("call method after :: {}", signature.getName());
    }
}
