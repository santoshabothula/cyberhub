
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
public class PreSignedUrl {

    @JsonProperty("preSignedUrl")
    private String preSignedUrl;

    @JsonProperty("httpMethod")
    private String httpMethod;


}

