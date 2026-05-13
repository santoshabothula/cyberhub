
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
public class AggregatedRiskTotalsSchema {

    @jakarta.validation.constraints.NotNull
    @JsonProperty("count")
    private Number count;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("industry_median")
    private Number industryMedian;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("monetary_impact")
    private Number monetaryImpact;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("monetary_impact_confidence")
    private Number monetaryImpactConfidence;

    @JsonProperty("probability_of_breach")
    private Float probabilityOfBreach;

    @JsonProperty("probability_of_breach_by_median")
    private Float probabilityOfBreachByMedian;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("score_median")
    private Number scoreMedian;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("underwriting_score_median")
    private Number underwritingScoreMedian;


}

