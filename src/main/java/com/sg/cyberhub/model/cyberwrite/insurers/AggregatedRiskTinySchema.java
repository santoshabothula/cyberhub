
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
public class AggregatedRiskTinySchema {

    @jakarta.validation.constraints.NotNull
    @JsonProperty("count")
    private Number count;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("percent")
    private Number percent;


}

