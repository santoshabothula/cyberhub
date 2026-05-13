
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
public class ResidualReportOutputSchema {

    @JsonProperty("act_total")
    private Number actTotal;

    @JsonProperty("breach_registered_by_cyberwrite")
    private Number breachRegisteredByCyberwrite;

    @JsonProperty("coverages")
    private List<@Valid ResidualCoverageSchema> coverages;

    @Valid
    @JsonProperty("impact_analysis")
    private ImpactAnalysisSchema impactAnalysis;

    @JsonProperty("median_risk_score")
    private Number medianRiskScore;

    @JsonProperty("policy_risk_score")
    private Number policyRiskScore;

    @JsonProperty("residual_score")
    private Number residualScore;

    @JsonProperty("residual_score_high")
    private Number residualScoreHigh;

    @JsonProperty("residual_score_low")
    private Number residualScoreLow;

    @JsonProperty("total_compare")
    private Number totalCompare;

    @JsonProperty("view_questions")
    private Boolean viewQuestions;


}

