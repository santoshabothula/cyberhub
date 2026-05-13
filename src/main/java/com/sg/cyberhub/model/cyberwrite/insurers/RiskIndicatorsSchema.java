
package com.sg.cyberhub.model.cyberwrite.insurers;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RiskIndicatorsSchema {

    @jakarta.validation.constraints.NotNull
    @Valid
    @JsonProperty("DDoS Mitigation")
    private RiskIndicatorSchema ddoSMitigation;

    @jakarta.validation.constraints.NotNull
    @Valid
    @JsonProperty("Exposed Credentials")
    private RiskIndicatorSchema exposedCredentials;

    @jakarta.validation.constraints.NotNull
    @Valid
    @JsonProperty("Open Ports")
    private RiskIndicatorSchema openPorts;

    @jakarta.validation.constraints.NotNull
    @Valid
    @JsonProperty("SSL Certificate")
    private RiskIndicatorSchema ssLCertificate;

    @jakarta.validation.constraints.NotNull
    @Valid
    @JsonProperty("Software Vulnerabilities")
    private RiskIndicatorSchema softwareVulnerabilities;

    @jakarta.validation.constraints.NotNull
    @Valid
    @JsonProperty("Spam Mitigation")
    private RiskIndicatorSchema spamMitigation;


}

