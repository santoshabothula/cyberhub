
package com.sg.cyberhub.model.cyberwrite.insurers;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SnapshotFullSchema {

    @Valid
    @JsonProperty("collected_data")
    private CollectedDataSchema collectedData;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("date")
    private OffsetDateTime date;

    @JsonProperty("duration")
    private Number duration;

    @Valid
    @JsonProperty("impact_analysis")
    private ImpactAnalysisSchema impactAnalysis;

    @jakarta.validation.constraints.NotNull
    @Valid
    @JsonProperty("insured_data")
    private SnapshotInsuredDataSchema insuredData;

    @JsonProperty("insured_id")
    private String insuredId;

    @jakarta.validation.constraints.NotNull
    @Valid
    @JsonProperty("insurer_data")
    private InsurerDataSchema insurerData;

    @JsonProperty("insurer_id")
    private String insurerId;

    @Valid
    @JsonProperty("questionnaire")
    private QuestionnaireSchema questionnaire;

    @JsonProperty("recommendations")
    private List<@Valid SnapshotRecommendationsSchema> recommendations;

    @Valid
    @JsonProperty("report")
    private ReportOutputSchema report;

    @JsonProperty("report_id")
    private String reportId;

    @JsonProperty("reprofile_initiated_by")
    private String reprofileInitiatedBy;

    @JsonProperty("security_questionnaire")
    private List<@Valid SecurityQuestionnaire> securityQuestionnaire;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("snapshot_id")
    private String snapshotId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("version")
    private Number version;


}

