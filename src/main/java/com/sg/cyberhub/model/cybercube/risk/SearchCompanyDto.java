
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
public class SearchCompanyDto {

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("eil")
    private String eil;

    @jakarta.validation.constraints.NotBlank
    @jakarta.validation.constraints.Size(min=1)
    @JsonProperty("companyName")
    private String companyName;

    @jakarta.validation.constraints.Size(min=2, max=2)
    @jakarta.validation.constraints.Pattern(regexp="^[A-Z]{2}$")
    @JsonProperty("companySize")
    private String companySize;

    @jakarta.validation.constraints.NotBlank
    @jakarta.validation.constraints.Size(min=4, max=4)
    @jakarta.validation.constraints.Pattern(regexp="^[0-9]{4}$")
    @JsonProperty("sic4")
    private String sic4;

    @jakarta.validation.constraints.DecimalMin(value="1", inclusive=true)
    @JsonProperty("revenue")
    private BigDecimal revenue;

    @jakarta.validation.constraints.Size(max=200)
    @JsonProperty("website")
    private String website;


}

