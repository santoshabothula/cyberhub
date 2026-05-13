
package com.sg.cyberhub.model.cyberwrite.insurers;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AggregatedRiskSchema {

    @Valid
    @JsonProperty("all")
    private AggregatedRiskAllSchema all;

    @JsonProperty("business_tags")
    private List<@Valid AggregatedRiskByBusinessTag> businessTags;

    @JsonProperty("by_country")
    private Map<String, AggregatedRiskAllSchema> byCountry;

    @JsonProperty("by_dns_providers")
    private Map<String, AggregatedRiskTinySchema> byDnsProviders;

    @JsonProperty("by_hosting_providers")
    private Map<String, AggregatedRiskTinySchema> byHostingProviders;

    @JsonProperty("by_isp_providers")
    private Map<String, AggregatedRiskTinySchema> byIspProviders;

    @JsonProperty("by_payment_providers")
    private Map<String, AggregatedRiskTinySchema> byPaymentProviders;

    @JsonProperty("by_sector")
    private Map<String, AggregatedRiskAllSchema> bySector;

    @JsonProperty("by_technology")
    private Map<String, Integer> byTechnology;

    @JsonProperty("by_technology_cves")
    private Map<String, AggregatedRiskShortSchema> byTechnologyCves;

    @JsonProperty("by_us_state")
    private Map<String, AggregatedRiskAllSchema> byUsState;

    @Valid
    @JsonProperty("stats")
    private AggregatedRiskStatsSchema stats;

    @JsonProperty("version")
    private Number version;


}

