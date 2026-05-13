
package com.sg.cyberhub.model.cyberwrite.insurers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecurityHeaderSchema {

    @JsonProperty("defined")
    private Boolean defined;

    @JsonProperty("details")
    private List<String> details;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("header")
    private String header;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("severity")
    private String severity;

    @JsonProperty("text")
    private String text;


}

