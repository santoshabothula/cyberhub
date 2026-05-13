
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
public class SslTlsCertificateSchema {

    @jakarta.validation.constraints.NotNull
    @JsonProperty("certificate_expired")
    private Boolean certificateExpired;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("certificate_expiry_date")
    private String certificateExpiryDate;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("certificate_issue_date")
    private String certificateIssueDate;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("certificate_issuer")
    private String certificateIssuer;

    @JsonProperty("text")
    private String text;


}

