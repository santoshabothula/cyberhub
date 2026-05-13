
package com.sg.cyberhub.model.cyberwrite.insurers;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsurerDataSchema {

    @Valid
    @JsonProperty("agency")
    private AgencySchema agency;

    @JsonProperty("agency_id")
    private String agencyId;

    @Valid
    @JsonProperty("insurer")
    private CompanySchema insurer;

    @jakarta.validation.constraints.NotNull
    @Valid
    @JsonProperty("user")
    private UserSchema user;


}

