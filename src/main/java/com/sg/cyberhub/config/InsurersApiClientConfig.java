package com.sg.cyberhub.config;

import com.sg.cyberhub.client.cyberwrite.InsurersApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Import(ApplicationConfig.class)
@Configuration
public class InsurersApiClientConfig {

    @Value("${cyberwrite.insurers.client.baseUrl}")
    private String baseUrl;

    @Value("${cyberwrite.insurers.client.key}")
    private String apiKey;

    @Value("${cyberwrite.insurers.client.insurer}")
    private String insurer;

    @Bean
    public InsurersApiClient insurerApiClient(WebClient webClient) {

//        RestClient restClient = builder
//                .baseUrl(formatBaseUrl())
//                .defaultHeader("Accept", "application/json")
//                .defaultHeader("x-api-key", apiKey)
//                .build();

        WebClient customWebClient = webClient.mutate()
                .baseUrl(formatBaseUrl())
                .defaultHeader("Accept", "application/json")
                .defaultHeader("x-api-key", apiKey)
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(customWebClient))
                .build();

        return factory.createClient(InsurersApiClient.class);
    }

    private String formatBaseUrl() {
        return baseUrl + "/insurers/" + insurer;
    }
}
