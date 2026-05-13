
package com.sg.cyberhub.model.cybercube.fl;

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
public class Accountv3Request {

    @jakarta.validation.constraints.Size(max=60)
    @JsonProperty("eil")
    private String eil;

    @jakarta.validation.constraints.Size(max=300)
    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("website")
    private String website;

    @jakarta.validation.constraints.Size(max=2)
    @JsonProperty("countryCode")
    private String countryCode;

    @JsonProperty("sic4")
    private String sic4;

    @JsonProperty("revenue")
    private BigDecimal revenue;

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
    private Accountv3RequestContingentBusinessInterruption contingentBusinessInterruption;

    @Valid
    @JsonProperty("businessInterruption")
    private Accountv3RequestBusinessInterruption businessInterruption;

    @Valid
    @JsonProperty("misdirectedPayment")
    private Accountv3RequestMisdirectedPayment misdirectedPayment;

    @Valid
    @JsonProperty("extortionPayment")
    private Accountv3RequestMisdirectedPayment extortionPayment;

    @Valid
    @JsonProperty("regulatoryFinesAndPenalties")
    private Accountv3RequestRegulatoryFinesAndPenalties regulatoryFinesAndPenalties;

    @Valid
    @JsonProperty("legalLiability")
    private Accountv3RequestLegalLiability legalLiability;

    @Valid
    @JsonProperty("dataRestoration")
    private Accountv3RequestDataRestoration dataRestoration;

    @Valid
    @JsonProperty("businessInterruptionLossBasis")
    private Accountv3RequestBusinessInterruptionLossBasis businessInterruptionLossBasis;

    @Valid
    @JsonProperty("investigationAndResponse")
    private Accountv3RequestInvestigationAndResponse investigationAndResponse;


}

