
package com.sg.cyberhub.model.cyberwrite.insurers;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuredReadSchema {

    @JsonProperty("action")
    private String action;

    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @Valid
    @JsonProperty("insured")
    private InsuredSchema insured;

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

    @JsonProperty("last_profiling_completed_at")
    private OffsetDateTime lastProfilingCompletedAt;

    @JsonProperty("last_profiling_initiated_at")
    private OffsetDateTime lastProfilingInitiatedAt;

    @JsonProperty("request_id")
    private String requestId;

    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;

    @JsonProperty("user")
    private String user;

    @JsonProperty("version")
    private Number version;

    @jakarta.validation.constraints.Size(min=1, max=2083)
    @JsonProperty("webhook_url")
    private URI webhookUrl;


}

