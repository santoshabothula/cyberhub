package com.sg.cyberhub.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspectConfig {

    @Around("execution(* com.sg..*(..))")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {

        String method = joinPoint.getSignature().toShortString();
        long start = System.currentTimeMillis();

        log.info("Entering {}", method);
        try {
            Object result = joinPoint.proceed();
            long time = System.currentTimeMillis() - start;
            log.info("Exiting {} ({} ms)", method, time);
            return result;

        } catch (Exception ex) {
            long time = System.currentTimeMillis() - start;
            log.error("Exception in {} ({} ms)", method, time, ex);
            throw ex;
        }
    }
}