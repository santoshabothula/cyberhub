
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
public class AggregatedRiskCoverageValues {

    @jakarta.validation.constraints.NotNull
    @JsonProperty("monetary_impact")
    private Number monetaryImpact;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("score_median")
    private Number scoreMedian;

    @JsonProperty("underwriting_score_median")
    private Float underwritingScoreMedian;


}

