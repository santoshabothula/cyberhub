package com.sg.cyberhub.controller.cyberwrite;

import com.sg.cyberhub.model.cyberwrite.insurers.AggregatedRiskSchema;
import com.sg.cyberhub.model.cyberwrite.insurers.InsurerSettingsSchema;
import com.sg.cyberhub.service.cyberwrite.InsurersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/cyberwrite/insurers")
@AllArgsConstructor
@Tag(name = "Cyber Write Insurers API", description = "API for managing insurers, insureds, and reports")
public class InsurersController {

    private InsurersService insurersService;

    @GetMapping("/settings")
    @Operation(summary = "Get Insurer Settings", description = "Retrieve insurer or agency settings")
    @ApiResponse(responseCode = "200", description = "Settings retrieved successfully")
    public ResponseEntity<Mono<InsurerSettingsSchema>> getInsurerSettings(
            @Parameter(description = "Agency ID") 
            @RequestParam(value = "agency", required = false) String agency
    ) {
        return ResponseEntity.ok(insurersService.getInsurerSettings(agency));
    }

    @GetMapping("/aggregated-risk")
    @Operation(summary = "Get Aggregated Risk", description = "Retrieve aggregated risk report")
    @ApiResponse(responseCode = "200", description = "Aggregated risk retrieved successfully")
    public ResponseEntity<Mono<AggregatedRiskSchema>> getAggregatedRisk(
            @Parameter(description = "Book to filter")
            @RequestParam(value = "book", required = false) String book,
            @Parameter(description = "Agency ID to filter")
            @RequestParam(value = "agency", required = false) String agency,
            @Parameter(description = "Start date filter")
            @RequestParam(value = "start_date", required = false) String startDate,
            @Parameter(description = "End date filter")
            @RequestParam(value = "end_date", required = false) String endDate
    ) {
        return ResponseEntity.ok(insurersService.getAggregatedRisk(book, agency, startDate, endDate));
    }
}

