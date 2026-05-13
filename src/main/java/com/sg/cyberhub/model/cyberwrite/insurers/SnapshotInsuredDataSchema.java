
package com.sg.cyberhub.model.cyberwrite.insurers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SnapshotInsuredDataSchema {

    @JsonProperty("assigned_id")
    private String assignedId;

    @JsonProperty("book")
    private String book;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("country")
    private String country;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("id")
    private String id;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("name")
    private String name;

    @JsonProperty("report_type")
    private String reportType;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("sector")
    private List<String> sector;

    @JsonProperty("us_state")
    private String usState;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("website")
    private String website;


}

