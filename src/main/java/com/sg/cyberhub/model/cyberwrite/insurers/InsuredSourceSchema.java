
package com.sg.cyberhub.model.cyberwrite.insurers;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuredSourceSchema {

    @JsonProperty("active")
    private Boolean active;

    @jakarta.validation.constraints.NotNull
    @Valid
    @JsonProperty("insured_data")
    private InsuredDataSchema insuredData;

    @JsonProperty("insured_id")
    private String insuredId;

    @jakarta.validation.constraints.NotNull
    @Valid
    @JsonProperty("insurer_data")
    private InsurerDataSchema insurerData;

    @JsonProperty("insurer_id")
    private String insurerId;

    @JsonProperty("user")
    private String user;

    @JsonProperty("version")
    private Number version;

    @jakarta.validation.constraints.Size(min=1, max=2083)
    @JsonProperty("webhook_url")
    private URI webhookUrl;


}

