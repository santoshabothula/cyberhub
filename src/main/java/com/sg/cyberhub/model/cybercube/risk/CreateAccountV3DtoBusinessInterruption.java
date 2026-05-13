
package com.sg.cyberhub.model.cybercube.risk;

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
public class CreateAccountV3DtoBusinessInterruption {

    @JsonProperty("include")
    private Boolean include;

    @JsonProperty("sublimitAmount")
    private BigDecimal sublimitAmount;

    @JsonProperty("deductibleAmount")
    private BigDecimal deductibleAmount;

    @JsonProperty("deductibleType")
    private String deductibleType;


}

