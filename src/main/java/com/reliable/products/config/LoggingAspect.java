package com.reliable.products.config;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Before(value = "execution(* com.reliable..*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        logger.info("Entering method: " + joinPoint.getSignature().toShortString());
    }


    @After(value = "execution(* com.reliable..*(..))")
    public void afterAdvice(JoinPoint joinPoint){
        logger.info("Exiting method: " + joinPoint.getSignature().toShortString());
    }
}
