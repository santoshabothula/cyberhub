
package com.sg.cyberhub.model.cyberwrite.insurers;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuredDataSchema {

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

    @Valid
    @JsonProperty("questionnaire_data")
    private QuestionnaireSchema questionnaireData;

    @JsonProperty("report_type")
    private String reportType;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("sector")
    private List<String> sector;

    @JsonProperty("security_questionnaire")
    private List<@Valid SecurityQuestionnaire> securityQuestionnaire;

    @JsonProperty("us_state")
    private String usState;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("website")
    private String website;


}

