
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
public class SnapshotRecommendationsSchema {

    @JsonProperty("tailored_cyber_security_standards")
    private List<@Valid CyberSecurityStandardSchema> tailoredCyberSecurityStandards;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("tailored_recommendations")
    private List<@Valid RecommendationSchema> tailoredRecommendations;


}

