package com.sg.cyberhub.config;

import io.netty.channel.ChannelOption;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import java.time.Duration;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient() {

        ConnectionProvider provider = ConnectionProvider.builder("custom-pool")
                .maxConnections(200) // total max connections
                .pendingAcquireTimeout(Duration.ofSeconds(5)) // wait time when pool exhausted
                .pendingAcquireMaxCount(500) // max waiting requests
                .maxIdleTime(Duration.ofSeconds(30)) // close idle connections
                .maxLifeTime(Duration.ofMinutes(5)) // close old connections
                .build();

        HttpClient httpClient = HttpClient.create(provider)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000) // connect timeout
                    .responseTimeout(Duration.ofSeconds(10)) // response timeout
                    .keepAlive(true) // keep alive
                    .wiretap(true); // wiretap logs

        return WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient)).build();
    }
}