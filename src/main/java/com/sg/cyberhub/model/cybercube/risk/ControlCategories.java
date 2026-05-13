
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
public class ControlCategories {

    @JsonProperty("grc")
    private ControlScore grc;

    @JsonProperty("ncm")
    private ControlScore ncm;

    @JsonProperty("iam")
    private ControlScore iam;

    @JsonProperty("vm")
    private ControlScore vm;

    @JsonProperty("md")
    private ControlScore md;

    @JsonProperty("ir")
    private ControlScore ir;


}

