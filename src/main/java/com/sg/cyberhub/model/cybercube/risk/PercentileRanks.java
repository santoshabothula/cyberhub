
package com.sg.cyberhub.model.cybercube.risk;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PercentileRanks {

    @jakarta.validation.constraints.Min(0)
    @jakarta.validation.constraints.Max(100)
    @JsonProperty("exposure")
    private Number exposure;

    @jakarta.validation.constraints.Min(0)
    @jakarta.validation.constraints.Max(100)
    @JsonProperty("security")
    private Number security;

    @JsonProperty("type")
    private String type;


}

