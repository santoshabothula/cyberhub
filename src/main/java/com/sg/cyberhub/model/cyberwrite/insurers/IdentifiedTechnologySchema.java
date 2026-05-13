
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
public class IdentifiedTechnologySchema {

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("description")
    private String description;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("first_detected")
    private String firstDetected;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("last_detected")
    private String lastDetected;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("link")
    private String link;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("name")
    private String name;


}

