package com.sg.cyberhub.cyberwrite.config;

import com.sg.cyberhub.cyberwrite.client.InsurersApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class InsurersApiClientConfig {

    @Value("${cyberwrite.insurers.client.baseUrl}")
    private String baseUrl;

    @Value("${cyberwrite.insurers.client.key}")
    private String apiKey;

    @Value("${cyberwrite.insurers.client.insurer}")
    private String insurer;

    @Bean
    public InsurersApiClient insurerApiClient(RestClient.Builder builder) {

        RestClient restClient = builder
                .baseUrl(formatBaseUrl())
                .defaultHeader("Accept", "application/json")
                .defaultHeader("x-api-key", apiKey)
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build();

        return factory.createClient(InsurersApiClient.class);
    }

    private String formatBaseUrl() {
        return baseUrl + "/insurers/" + insurer;
    }
}
