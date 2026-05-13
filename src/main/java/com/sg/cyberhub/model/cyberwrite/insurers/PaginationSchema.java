
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
public class PaginationSchema {

    @jakarta.validation.constraints.NotNull
    @JsonProperty("limit")
    private Number limit;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("skip")
    private Number skip;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("total")
    private Number total;


}

