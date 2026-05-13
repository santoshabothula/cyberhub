
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
public class AggregatedRiskByBusinessTag {

    @jakarta.validation.constraints.NotNull
    @JsonProperty("amount")
    private Number amount;

    @JsonProperty("average_probable_loss")
    private Float averageProbableLoss;

    @JsonProperty("median_risk_score")
    private Float medianRiskScore;

    @JsonProperty("stdev_risk_score")
    private Float stdevRiskScore;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("sum_probable_loss")
    private Number sumProbableLoss;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("tag")
    private String tag;


}

