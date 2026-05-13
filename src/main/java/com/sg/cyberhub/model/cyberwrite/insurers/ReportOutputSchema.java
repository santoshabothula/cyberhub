
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
public class ReportOutputSchema {

    @jakarta.validation.constraints.NotNull
    @JsonProperty("coverages")
    private List<@Valid CoverageSchema> coverages;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("median_risk_score")
    private Number medianRiskScore;

    @JsonProperty("priority_score")
    private Number priorityScore;

    @JsonProperty("rejected")
    private Boolean rejected;

    @JsonProperty("rejection_reason")
    private List<String> rejectionReason;

    @Valid
    @JsonProperty("residual_report")
    private ResidualReportOutputSchema residualReport;

    @JsonProperty("residual_score")
    private Number residualScore;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("risk_domains")
    private List<@Valid RiskDomainSchema> riskDomains;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("riskprofile_score")
    private Number riskprofileScore;

    @JsonProperty("underwriting_recommendation")
    private String underwritingRecommendation;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("underwriting_total")
    private Number underwritingTotal;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("view_questions")
    private Boolean viewQuestions;


}

