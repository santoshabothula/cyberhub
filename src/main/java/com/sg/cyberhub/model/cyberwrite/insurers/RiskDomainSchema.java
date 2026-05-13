
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
public class RiskDomainSchema {

    @JsonProperty("description")
    private String description;

    @JsonProperty("domain_name")
    private String domainName;

    @JsonProperty("level")
    private String level;

    @JsonProperty("score")
    private Number score;


}

