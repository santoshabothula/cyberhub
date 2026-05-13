
package com.sg.cyberhub.model.cyberwrite.insurers;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RejectedDataSchema {

    @jakarta.validation.constraints.NotNull
    @JsonProperty("date")
    private OffsetDateTime date;

    @jakarta.validation.constraints.NotNull
    @Valid
    @JsonProperty("insured_data")
    private InsuredDataSchema insuredData;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("insured_id")
    private String insuredId;


}

