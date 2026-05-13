
package com.sg.cyberhub.model.cyberwrite.insurers;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AggregatedRiskStatsSchema {

    @jakarta.validation.constraints.NotNull
    @JsonProperty("max_date")
    private OffsetDateTime maxDate;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("median_duration_seconds")
    private Number medianDurationSeconds;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("min_date")
    private OffsetDateTime minDate;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("rejected")
    private List<@Valid RejectedDataSchema> rejected;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("rejected_count")
    private Number rejectedCount;


}

