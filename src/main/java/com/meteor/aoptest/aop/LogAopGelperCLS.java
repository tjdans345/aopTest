package com.meteor.aoptest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LogAopGelperCLS {

    private static final Logger logger = LoggerFactory.getLogger(LogAopGelperCLS.class);

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void GetMapping(){ }

    @Before("GetMapping()")
    public void before(JoinPoint joinPoint) {
        logger.info("=====================AspectJ TEST  : Before Logging Start=====================");

        logger.info("=====================AspectJ TEST  : Before Logging End=====================");
    }

    @AfterReturning(pointcut = "GetMapping()", returning = "result")
    public void AfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("=====================AspectJ TEST  : AfterReturning Logging Start=====================");
        logger.info("=====================AspectJ TEST  : AfterReturning Logging END=====================");
    }

    @Around("GetMapping()")
    public Object Around(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("=====================AspectJ TEST  : Around Logging Start=====================");
        try {
            Object result = joinPoint.proceed();
            logger.info("=====================AspectJ TEST  : Around Logging END=====================");
            return result;
        }catch (Exception e) {
            logger.error("=====================AspectJ Around Exception=====================");
            logger.error(e.toString());
            return null;
        }
    }


}
