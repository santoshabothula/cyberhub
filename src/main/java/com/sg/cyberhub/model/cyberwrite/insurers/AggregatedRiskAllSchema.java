
package com.sg.cyberhub.model.cyberwrite.insurers;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AggregatedRiskAllSchema {

    @jakarta.validation.constraints.NotNull
    @JsonProperty("count")
    private Number count;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("coverages")
    private Map<String, AggregatedRiskCoverageValues> coverages;

    @jakarta.validation.constraints.NotNull
    @Valid
    @JsonProperty("totals")
    private AggregatedRiskTotalsSchema totals;


}

