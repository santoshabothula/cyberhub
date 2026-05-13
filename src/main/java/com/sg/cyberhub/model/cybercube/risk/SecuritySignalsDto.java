
package com.sg.cyberhub.model.cybercube.risk;

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
public class SecuritySignalsDto {

    @JsonProperty("signalName")
    private String signalName;

    @JsonProperty("month")
    private String month;

    @JsonProperty("signalState")
    private String signalState;

    @JsonProperty("signalDetails")
    private List<@Valid SignalDetails> signalDetails;

    @JsonProperty("actionableFindings")
    private List<@Valid ActionableFinding> actionableFindings;

    @JsonProperty("countRange")
    private String countRange;


}

