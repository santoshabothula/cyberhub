
package com.sg.cyberhub.model.cybercube.fl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RunAnalysisResponse {

    @JsonProperty("analysisId")
    private String analysisId;


}

