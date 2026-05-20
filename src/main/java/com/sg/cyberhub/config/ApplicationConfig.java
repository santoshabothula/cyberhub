package com.sg.cyberhub.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.apache.hc.client5.http.config.ConnectionConfig;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.DefaultHttpRequestRetryStrategy;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClient;

@Configuration
public class ApplicationConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
//        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        mapper.registerModule(new JavaTimeModule());
        mapper.registerModule(new ParameterNamesModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.enable(DeserializationFeature.USE_LONG_FOR_INTS);
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    @Bean
    public RestClient restClient(ObjectMapper objectMapper) {

        ConnectionConfig connectionConfig = ConnectionConfig.custom()
                .setValidateAfterInactivity(TimeValue.ofSeconds(5)) // validate stale connections
                .setTimeToLive(TimeValue.ofMinutes(5)) // connection TTL
                .build();

        // Connection Pool
        PoolingHttpClientConnectionManager connectionManager = PoolingHttpClientConnectionManagerBuilder.create()
                .setMaxConnTotal(100) // max total connections
                .setMaxConnPerRoute(20) // max per route
                .setDefaultConnectionConfig(connectionConfig)
                .build();

        // Timeout configuration
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(Timeout.ofSeconds(5)) // TCP connect timeout
                .setResponseTimeout(Timeout.ofSeconds(10)) // Response timeout
                .build();

        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager) // Use connection pool
                .setDefaultRequestConfig(requestConfig) // Default request config
                .setRetryStrategy(new DefaultHttpRequestRetryStrategy(3, TimeValue.ofSeconds(2)))
                .evictIdleConnections(TimeValue.ofSeconds(30)) // Remove idle connections
                .setKeepAliveStrategy((response, context) -> TimeValue.ofSeconds(30)) // Keep a live strategy
                .build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);

        return RestClient.builder()
                .requestFactory(factory)
                .messageConverters(converters -> converters.add(new MappingJackson2HttpMessageConverter(objectMapper)))
                .build();
    }
}
