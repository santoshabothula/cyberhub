
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
public class SecurityQuestionnaire {

    @jakarta.validation.constraints.NotNull
    @Valid
    @JsonProperty("answer")
    private Object answer;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("attack_vectors")
    private List<String> attackVectors;

    @JsonProperty("file")
    private String file;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("id")
    private String id;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("question")
    private String question;

    @JsonProperty("recommendations")
    private List<String> recommendations;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("type")
    private String type;


}

