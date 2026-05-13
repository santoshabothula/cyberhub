
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
public class CompanySchema {

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("id")
    private String id;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("name")
    private String name;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("type")
    private String type;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("website")
    private String website;


}

