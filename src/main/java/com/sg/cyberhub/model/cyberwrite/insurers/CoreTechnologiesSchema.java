
package com.sg.cyberhub.model.cyberwrite.insurers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoreTechnologiesSchema {

    @JsonProperty("dns_providers")
    private List<String> dnsProviders;

    @JsonProperty("hosting_providers")
    private List<String> hostingProviders;

    @JsonProperty("isp_providers")
    private List<String> ispProviders;

    @JsonProperty("payment_service_providers")
    private List<String> paymentServiceProviders;


}

