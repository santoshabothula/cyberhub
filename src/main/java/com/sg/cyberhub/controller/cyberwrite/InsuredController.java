package com.sg.cyberhub.controller.cyberwrite;

import com.sg.cyberhub.model.cyberwrite.insurers.*;
import com.sg.cyberhub.service.cyberwrite.InsurersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/cyberwrite/insureds")
@AllArgsConstructor
@Tag(name = "Cyber Write Insureds API", description = "API for managing insurers, insureds, and reports")
public class InsuredController {

    private InsurersService insurersService;

    @GetMapping
    @Operation(summary = "Search Insureds", description = "Search insureds by filter criteria")
    @ApiResponse(responseCode = "200", description = "Insureds list retrieved successfully")
    public ResponseEntity<Mono<InsuredsListSchema>> searchInsureds(
            @Parameter(description = "Number of items per page")
            @RequestParam(value = "limit", defaultValue = "100") int limit,
            @Parameter(description = "Number of items to skip")
            @RequestParam(value = "skip", defaultValue = "0") int skip,
            @Parameter(description = "Insured assigned ID")
            @RequestParam(value = "assigned_id", required = false) String assignedId,
            @Parameter(description = "Search by name or website")
            @RequestParam(value = "search", required = false) String search
    ) {
        return ResponseEntity.ok(insurersService.searchInsureds(limit, skip, assignedId, search));
    }

    @DeleteMapping("/{insured}")
    @Operation(summary = "Delete Insured", description = "Delete an insured record")
    @ApiResponse(responseCode = "200", description = "Insured deleted successfully")
    public ResponseEntity<Mono<InsuredsDeleteSchema>> deleteInsured(
            @Parameter(description = "Insured UUID")
            @PathVariable String insured
    ) {
        return ResponseEntity.ok(insurersService.deleteInsured(insured));
    }

    @GetMapping("/{insured}")
    @Operation(summary = "Read Insured", description = "Get specific insured details")
    @ApiResponse(responseCode = "200", description = "Insured details retrieved successfully")
    public ResponseEntity<Mono<InsuredReadSchema>> readInsured(
            @Parameter(description = "Insured UUID")
            @PathVariable String insured
    ) {
        return ResponseEntity.ok(insurersService.readInsured(insured));
    }

    @PutMapping("/{insured}")
    @Operation(summary = "Update Insured", description = "Update an insured record")
    @ApiResponse(responseCode = "200", description = "Insured updated successfully")
    public ResponseEntity<Mono<InsuredsCreateSchema>> updateInsured(
            @Parameter(description = "Insured UUID")
            @PathVariable String insured,
            @RequestBody InsuredSourceSchema request
    ) {
        return ResponseEntity.ok(insurersService.createInsured(insured, request));
    }

    @PostMapping("/{insured}/reprofile")
    @Operation(summary = "Reprofile Insured", description = "Trigger reprofile for an insured")
    @ApiResponse(responseCode = "200", description = "Reprofile initiated successfully")
    public ResponseEntity<Mono<InsuredsReprofileSchema>> reProfileInsured(
            @Parameter(description = "Insured UUID")
            @PathVariable String insured
    ) {
        return ResponseEntity.ok(insurersService.reProfileInsured(insured));
    }
}
