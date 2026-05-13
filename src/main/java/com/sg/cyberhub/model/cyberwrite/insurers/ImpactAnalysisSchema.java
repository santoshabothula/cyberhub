
package com.sg.cyberhub.model.cyberwrite.insurers;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImpactAnalysisSchema {

    @jakarta.validation.constraints.NotNull
    @JsonProperty("coverages")
    private List<@Valid ImpactAnalysisCoverageSchema> coverages;

    @JsonProperty("graph_max")
    private Number graphMax;

    @JsonProperty("graph_min")
    private Number graphMin;

    @JsonProperty("prob_loss_high")
    private Number probLossHigh;

    @JsonProperty("prob_loss_low")
    private Number probLossLow;

    @JsonProperty("residual_max_loss")
    private Number residualMaxLoss;

    @JsonProperty("total_high")
    private Number totalHigh;

    @JsonProperty("total_low")
    private Number totalLow;

    @JsonProperty("total_prob_high")
    private Number totalProbHigh;

    @JsonProperty("total_prob_low")
    private Number totalProbLow;

    @JsonProperty("total_prob_xyz_high")
    private Number totalProbXyzHigh;

    @JsonProperty("total_prob_xyz_low")
    private Number totalProbXyzLow;


}

