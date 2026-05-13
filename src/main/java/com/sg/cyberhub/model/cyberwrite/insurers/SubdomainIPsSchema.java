
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
public class SubdomainIPsSchema {

    @JsonProperty("country")
    private String country;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("ip")
    private String ip;


}

