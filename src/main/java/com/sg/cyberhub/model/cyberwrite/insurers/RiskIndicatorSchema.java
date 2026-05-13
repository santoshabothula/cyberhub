
package com.sg.cyberhub.model.cyberwrite.insurers;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RiskIndicatorSchema {

    @jakarta.validation.constraints.NotNull
    @Valid
    @JsonProperty("details")
    private Object details;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("status")
    private String status;


}

