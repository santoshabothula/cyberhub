
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
public class InsuredsReprofileSchema {

    @JsonProperty("action")
    private String action;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("request_id")
    private String requestId;

    @JsonProperty("success")
    private Boolean success;


}

