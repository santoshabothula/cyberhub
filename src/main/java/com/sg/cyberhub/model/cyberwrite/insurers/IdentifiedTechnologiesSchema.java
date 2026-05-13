
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
public class IdentifiedTechnologiesSchema {

    @jakarta.validation.constraints.NotNull
    @JsonProperty("data")
    private List<@Valid IdentifiedTechnologiesByDomainSchema> data;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("total")
    private Number total;


}

