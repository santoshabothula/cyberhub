
package com.sg.cyberhub.model.cybercube.risk;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActionableFinding {

    @JsonProperty("vendor")
    private String vendor;

    @JsonProperty("technologyCategory")
    private String technologyCategory;

    @JsonProperty("product")
    private String product;


}

