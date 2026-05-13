
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
public class AggregatedRiskShortSchema {

    @jakarta.validation.constraints.NotNull
    @JsonProperty("count")
    private Number count;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("max")
    private Number max;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("median")
    private Number median;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("min")
    private Number min;


}

