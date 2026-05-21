package com.sg.cyberhub.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sg.cyberhub.entity.LogTrace;
import com.sg.cyberhub.repository.LogTraceRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

import static com.sg.cyberhub.util.CommonUtil.CORRELATION_ID_MDC_KEY;

@Aspect
@Component
@AllArgsConstructor
@ConfigurationProperties(prefix = "app.logging")
public class LoggingAspectConfig {

    private final LogTraceRepository logTraceRepository;
    private final ObjectMapper objectMapper;
    private final LoggingProperties loggingProperties;

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
        log(clazz.getName(), method, null, "Entering", uri, httpMethod, getRequestBody(joinPoint.getArgs()), null);
        try {
            Object result = joinPoint.proceed();
            long time = System.currentTimeMillis() - start;
            log.info("Exiting {} ({} ms), URI: {} {}", method, time, httpMethod, uri);
            log(clazz.getName(), method, time, "Existing", uri, httpMethod, null, getResponseBody(result));
            return result;
        } catch (Exception ex) {
            long time = System.currentTimeMillis() - start;
            log.error("Exception in {} ({} ms), URI: {} {}", method, time, httpMethod, uri, ex);
            log(clazz.getName(), method, time, "Exception", uri, httpMethod, null, null);
            throw ex;
        }
    }

    private void log(
            String className, String method, Long endTime, String message, String api, String apiMethod, String req, String res
    ) {
        logTraceRepository.save(
                LogTrace.builder()
                        .correlationId(MDC.get(CORRELATION_ID_MDC_KEY))
                        .className(className)
                        .method(method)
                        .totalTimeTaken(endTime)
                        .log(message)
                        .api(api)
                        .apiMethod(apiMethod)
                        .request(req)
                        .response(res)
                        .build()
        );
    }

    private String getRequestBody(Object[] args) {
        try {
            if (!loggingProperties.isRequestEnabled()) return null;

            Object[] filteredArgs = Arrays.stream(args)
                    .filter(arg -> !(arg instanceof HttpServletRequest))
                    .toArray();
            return objectMapper.writeValueAsString(filteredArgs);
        } catch (JsonProcessingException e) {
            return "Unable to serialize request";
        }
    }

    private String getResponseBody(Object result) {
        try {
            if (!loggingProperties.isResponseEnabled()) return null;

            return objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            return "Unable to serialize response";
        }
    }
}