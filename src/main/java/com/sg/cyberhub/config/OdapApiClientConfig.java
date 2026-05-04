package com.sg.cyberhub.config;

import com.sg.cyberhub.client.cybercube.OdapApiFlClient;
import com.sg.cyberhub.client.cybercube.OdapRiskApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Import(ApplicationConfig.class)
@Configuration
public class OdapApiClientConfig {

    @Value("${cybercube.odap.client.baseUrl}")
    private String baseUrl;

    @Value("${cybercube.odap.client.key}")
    private String apiKey;

    @Bean
    public OdapApiFlClient odapApiClient(RestClient.Builder builder) {

        RestClient restClient = builder
                .baseUrl(formatBaseUrl())
                .defaultHeader("Accept", "application/json")
                .defaultHeader("x-api-key", apiKey)
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build();

        return factory.createClient(OdapApiFlClient.class);
    }

    @Bean
    public OdapRiskApiClient odapApiRiskClient(RestClient.Builder builder) {

        RestClient restClient = builder
                .baseUrl(formatBaseUrl())
                .defaultHeader("Accept", "application/json")
                .defaultHeader("x-api-key", apiKey)
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build();

        return factory.createClient(OdapRiskApiClient.class);
    }

    private String formatBaseUrl() {
        return baseUrl + "/odap";
    }
}
