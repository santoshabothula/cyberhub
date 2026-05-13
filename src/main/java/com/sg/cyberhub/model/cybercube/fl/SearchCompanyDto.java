
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
public class SearchCompanyDto {

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("eil")
    private String eil;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("companySize")
    private String companySize;

    @JsonProperty("countryCode")
    private String countryCode;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("sic4")
    private String sic4;

    @JsonProperty("revenue")
    private BigDecimal revenue;

    @JsonProperty("website")
    private String website;


}

