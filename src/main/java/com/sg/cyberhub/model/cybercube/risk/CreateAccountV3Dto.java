
package com.sg.cyberhub.model.cybercube.risk;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountV3Dto {

    @jakarta.validation.constraints.Size(max=60)
    @JsonProperty("eil")
    private String eil;

    @jakarta.validation.constraints.NotBlank
    @jakarta.validation.constraints.Size(max=300)
    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("website")
    private String website;

    @jakarta.validation.constraints.NotBlank
    @jakarta.validation.constraints.Size(max=2)
    @JsonProperty("countryCode")
    private String countryCode;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("sic4")
    private String sic4;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("revenue")
    private BigDecimal revenue;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("companySize")
    private String companySize;

    @JsonProperty("recordsCount")
    private BigDecimal recordsCount;

    @JsonProperty("contractType")
    private String contractType;

    @JsonProperty("policyPremium")
    private BigDecimal policyPremium;

    @JsonProperty("limits")
    private BigDecimal limits;

    @JsonProperty("deductible")
    private BigDecimal deductible;

    @JsonProperty("attachmentPoint")
    private BigDecimal attachmentPoint;

    @JsonProperty("participationPercentage")
    private Double participationPercentage;

    @Valid
    @JsonProperty("contingentBusinessInterruption")
    private CreateAccountV3DtoContingentBusinessInterruption contingentBusinessInterruption;

    @Valid
    @JsonProperty("businessInterruption")
    private CreateAccountV3DtoBusinessInterruption businessInterruption;

    @Valid
    @JsonProperty("misdirectedPayment")
    private CreateAccountV3DtoMisdirectedPayment misdirectedPayment;

    @Valid
    @JsonProperty("extortionPayment")
    private CreateAccountV3DtoMisdirectedPayment extortionPayment;

    @Valid
    @JsonProperty("regulatoryFinesAndPenalties")
    private CreateAccountV3DtoRegulatoryFinesAndPenalties regulatoryFinesAndPenalties;

    @Valid
    @JsonProperty("legalLiability")
    private CreateAccountV3DtoLegalLiability legalLiability;

    @Valid
    @JsonProperty("dataRestoration")
    private CreateAccountV3DtoDataRestoration dataRestoration;

    @Valid
    @JsonProperty("businessInterruptionLossBasis")
    private CreateAccountV3DtoBusinessInterruptionLossBasis businessInterruptionLossBasis;

    @Valid
    @JsonProperty("investigationAndResponse")
    private CreateAccountV3DtoInvestigationAndResponse investigationAndResponse;


}

