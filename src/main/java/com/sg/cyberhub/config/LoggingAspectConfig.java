package com.sg.cyberhub.config;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LoggingAspectConfig {

    @Around("execution(* com.sg..*Controller.*(..))")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {

        String method = joinPoint.getSignature().toShortString();
        long start = System.currentTimeMillis();

        Class<?> clazz = joinPoint.getTarget().getClass();
        Logger log = LoggerFactory.getLogger(clazz);

        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attrs.getRequest();
        String httpMethod = request.getMethod();
        String uri = request.getRequestURI();
        log.info("Entering {}, URI: {} {}", method, httpMethod, uri);
        try {
            Object result = joinPoint.proceed();
            long time = System.currentTimeMillis() - start;
            log.info("Exiting {} ({} ms), URI: {} {}", method, time, httpMethod, uri);
            return result;
        } catch (Exception ex) {
            long time = System.currentTimeMillis() - start;
            log.error("Exception in {} ({} ms), URI: {} {}", method, time, httpMethod, uri, ex);
            throw ex;
        }
    }
}