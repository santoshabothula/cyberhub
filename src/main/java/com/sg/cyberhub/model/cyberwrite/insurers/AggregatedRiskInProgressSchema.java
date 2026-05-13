
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
public class AggregatedRiskInProgressSchema {

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("message")
    private String message;

    @JsonProperty("success")
    private Boolean success;


}

