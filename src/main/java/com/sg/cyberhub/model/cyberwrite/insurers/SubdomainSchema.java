
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
public class SubdomainSchema {

    @jakarta.validation.constraints.NotNull
    @JsonProperty("ips")
    private List<@Valid SubdomainIPsSchema> ips;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("subdomain")
    private String subdomain;


}

