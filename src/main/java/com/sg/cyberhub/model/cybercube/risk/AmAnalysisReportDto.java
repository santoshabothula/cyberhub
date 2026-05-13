
package com.sg.cyberhub.model.cybercube.risk;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AmAnalysisReportDto {

    @JsonProperty("accountId")
    private UUID accountId;

    @JsonProperty("analysisId")
    private UUID analysisId;

    @Valid
    @JsonProperty("reportStatus")
    private Status reportStatus;

    @Valid
    @JsonProperty("report")
    private PreSignedUrl report;


}

