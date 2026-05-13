
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
public class IdentifiedTechnologiesByDomainSchema {

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("domain")
    private String domain;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("technologies")
    private List<@Valid IdentifiedTechnologySchema> technologies;


}

