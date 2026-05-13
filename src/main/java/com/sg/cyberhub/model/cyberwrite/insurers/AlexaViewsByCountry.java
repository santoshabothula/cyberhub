
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
public class AlexaViewsByCountry {

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("page_views")
    private String pageViews;

    @JsonProperty("rank")
    private Number rank;

    @JsonProperty("users")
    private String users;


}

