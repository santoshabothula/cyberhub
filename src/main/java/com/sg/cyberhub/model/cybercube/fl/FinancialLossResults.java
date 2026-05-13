
package com.sg.cyberhub.model.cybercube.fl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinancialLossResults {

    @JsonProperty("expectedLoss")
    private Double expectedLoss;

    @JsonProperty("averageFrequency")
    private Double averageFrequency;

    @JsonProperty("averageSeverity")
    private Double averageSeverity;

    @JsonProperty("coefficientOfVariation")
    private Double coefficientOfVariation;

    @JsonProperty("standardDeviation")
    private Double standardDeviation;

    @JsonProperty("probabilityOfAttachment")
    private Double probabilityOfAttachment;

    @JsonProperty("probabilityOfExhaustion")
    private Double probabilityOfExhaustion;

    @JsonProperty("modelledLossRatio")
    private Double modelledLossRatio;


}

