
package com.sg.cyberhub.model.cyberwrite.insurers;

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
public class VulnerableTechSchema {

    @jakarta.validation.constraints.NotNull
    @JsonProperty("scope")
    private List<@Valid Scope> scope;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("vulnerabilities")
    private List<@Valid VulnerabilitySchema> vulnerabilities;


}

