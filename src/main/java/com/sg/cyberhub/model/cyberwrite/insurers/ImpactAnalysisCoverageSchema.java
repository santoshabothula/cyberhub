
package com.sg.cyberhub.model.cyberwrite.insurers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImpactAnalysisCoverageSchema {

    @JsonProperty("code")
    private String code;

    @JsonProperty("coverage_name")
    private String coverageName;

    @JsonProperty("max")
    private Number max;

    @JsonProperty("min")
    private Number min;

    @JsonProperty("prob_max")
    private Number probMax;

    @JsonProperty("prob_min")
    private Number probMin;


}

