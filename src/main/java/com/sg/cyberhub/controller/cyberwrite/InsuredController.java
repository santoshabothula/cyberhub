package com.sg.cyberhub.controller.cyberwrite;

import com.sg.cyberhub.model.cyberwrite.insurers.*;
import com.sg.cyberhub.service.cyberwrite.InsurersService;
import com.sg.cyberhub.util.CommonUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cyberwrite/insureds")
@AllArgsConstructor
@Tag(name = "Cyber Write Insureds API", description = "API for managing insurers, insureds, and reports")
public class InsuredController {

    private InsurersService insurersService;

    @GetMapping
    @Operation(summary = "Search Insureds", description = "Search insureds by filter criteria")
    @ApiResponse(responseCode = "200", description = "Insureds list retrieved successfully")
    public ResponseEntity<InsuredsListSchema> searchInsureds(
            @Parameter(description = "Number of items per page")
            @RequestParam(value = "limit", defaultValue = "100") int limit,
            @Parameter(description = "Number of items to skip")
            @RequestParam(value = "skip", defaultValue = "0") int skip,
            @Parameter(description = "Insured assigned ID")
            @RequestParam(value = "assigned_id", required = false) String assignedId,
            @Parameter(description = "Search by name or website")
            @RequestParam(value = "search", required = false) String search
    ) {
        InsuredsListSchema result = insurersService.searchInsureds(limit, skip, assignedId, search);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{insured}")
    @Operation(summary = "Delete Insured", description = "Delete an insured record")
    @ApiResponse(responseCode = "200", description = "Insured deleted successfully")
    public ResponseEntity<InsuredsDeleteSchema> deleteInsured(
            @Parameter(description = "Insured UUID")
            @PathVariable String insured
    ) {
        InsuredsDeleteSchema result = insurersService.deleteInsured(insured);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{insured}")
    @Operation(summary = "Read Insured", description = "Get specific insured details")
    @ApiResponse(responseCode = "200", description = "Insured details retrieved successfully")
    public ResponseEntity<InsuredReadSchema> readInsured(
            @Parameter(description = "Insured UUID")
            @PathVariable String insured
    ) {
        InsuredReadSchema result = insurersService.readInsured(insured);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @Operation(summary = "Create Insured", description = "Create an insured record")
    @ApiResponse(responseCode = "200", description = "Insured created successfully")
    public ResponseEntity<InsuredsCreateSchema> createInsured(@RequestBody InsuredSourceSchema request) {
        InsuredsCreateSchema result = insurersService.createInsured(CommonUtil.generateUUIDAsString(), request);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{insured}")
    @Operation(summary = "Update Insured", description = "Update an insured record")
    @ApiResponse(responseCode = "200", description = "Insured updated successfully")
    public ResponseEntity<InsuredsCreateSchema> updateInsured(
            @Parameter(description = "Insured UUID")
            @PathVariable String insured,
            @RequestBody InsuredSourceSchema request
    ) {
        InsuredsCreateSchema result = insurersService.createInsured(insured, request);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/{insured}/reprofile")
    @Operation(summary = "Reprofile Insured", description = "Trigger reprofile for an insured")
    @ApiResponse(responseCode = "200", description = "Reprofile initiated successfully")
    public ResponseEntity<InsuredsReprofileSchema> reProfileInsured(
            @Parameter(description = "Insured UUID")
            @PathVariable String insured
    ) {
        InsuredsReprofileSchema result = insurersService.reProfileInsured(insured);
        return ResponseEntity.ok(result);
    }
}
