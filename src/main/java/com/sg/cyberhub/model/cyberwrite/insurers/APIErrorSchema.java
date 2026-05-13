
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
public class APIErrorSchema {

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("errorMessage")
    private String errorMessage;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("request_id")
    private String requestId;


}

