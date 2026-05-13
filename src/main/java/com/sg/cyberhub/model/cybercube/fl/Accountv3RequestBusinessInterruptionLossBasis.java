
package com.sg.cyberhub.model.cybercube.fl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Accountv3RequestBusinessInterruptionLossBasis {

    @JsonProperty("include")
    private Boolean include;

    @JsonProperty("lossBasisType")
    private String lossBasisType;

    @JsonProperty("lossBasisAmount")
    private BigDecimal lossBasisAmount;


}

