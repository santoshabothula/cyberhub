package com.sg.cyberhub.config;

import com.sg.cyberhub.entity.LogTrace;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static com.sg.cyberhub.util.CommonUtil.CORRELATION_ID_MDC_KEY;

@Aspect
@Component
@AllArgsConstructor
public class LoggingAspectConfig {

//    private LogTraceRepository logTraceRepository;

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
        log(clazz.getName(), method, null, "Entering", uri, httpMethod);
        try {
            Object result = joinPoint.proceed();
            long time = System.currentTimeMillis() - start;
            log.info("Exiting {} ({} ms), URI: {} {}", method, time, httpMethod, uri);
            log(clazz.getName(), method, time, "Existing", uri, httpMethod);
            return result;
        } catch (Exception ex) {
            long time = System.currentTimeMillis() - start;
            log.error("Exception in {} ({} ms), URI: {} {}", method, time, httpMethod, uri, ex);
            log(clazz.getName(), method, time, "Exception", uri, httpMethod);
            throw ex;
        }
    }

    private void log(String className, String method, Long endTime, String message, String api, String apiMethod) {
//        logTraceRepository.save(
                LogTrace.builder()
                        .correlationId(MDC.get(CORRELATION_ID_MDC_KEY))
                        .className(className)
                        .method(method)
                        .totalTimeTaken(endTime)
                        .log(message)
                        .api(api)
                        .apiMethod(apiMethod)
                        .build();
//        );
    }
}