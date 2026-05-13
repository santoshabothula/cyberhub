
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
public class RecommendationSchema {

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("category")
    private String category;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("rec_id")
    private String recId;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("recommendation")
    private String recommendation;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("severity")
    private String severity;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("status")
    private String status;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("title")
    private String title;


}

