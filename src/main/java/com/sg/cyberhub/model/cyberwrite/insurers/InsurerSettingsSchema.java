
package com.sg.cyberhub.model.cyberwrite.insurers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsurerSettingsSchema {

    @jakarta.validation.constraints.NotNull
    @JsonProperty("countries")
    private List<String> countries;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("currencies")
    private List<String> currencies;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("default_country")
    private String defaultCountry;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("default_currency")
    private String defaultCurrency;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("languages")
    private List<String> languages;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("sectors")
    private List<String> sectors;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("usa_states")
    private List<String> usaStates;


}

