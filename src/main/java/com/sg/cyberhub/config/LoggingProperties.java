package com.sg.cyberhub.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app.logging")
public class LoggingProperties {
    private boolean requestEnabled;
    private boolean responseEnabled;
}
