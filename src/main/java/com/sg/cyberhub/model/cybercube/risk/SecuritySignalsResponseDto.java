
package com.sg.cyberhub.model.cybercube.risk;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecuritySignalsResponseDto {

    @JsonProperty("accountId")
    private UUID accountId;

    @JsonProperty("analysisId")
    private UUID analysisId;

    @Valid
    @JsonProperty("analysisStatus")
    private Status analysisStatus;

    @JsonProperty("executionDate")
    private String executionDate;

    @JsonProperty("securitySignals")
    private List<@Valid SecuritySignalsDto> securitySignals;


}

