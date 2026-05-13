
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
public class CoverageSchema {

    @JsonProperty("code")
    private String code;

    @JsonProperty("industry_med_score")
    private Number industryMedScore;

    @JsonProperty("score")
    private Number score;

    @JsonProperty("type")
    private String type;

    @JsonProperty("underwriting_score")
    private Number underwritingScore;


}

