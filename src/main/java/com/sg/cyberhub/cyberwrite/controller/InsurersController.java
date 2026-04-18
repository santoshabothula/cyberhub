package com.sg.cyberhub.cyberwrite.controller;

import com.sg.cyberhub.cyberwrite.service.InsurersService;
import com.sg.cyberhub.model.cyberwrite.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cyberwrite/insurers")
@AllArgsConstructor
@Tag(name = "Cyber Write Insurers API", description = "API for managing insurers, insureds, and reports")
public class InsurersController {

    private InsurersService insurersService;

    // ============ Insurer Settings API ============
    @GetMapping("/settings")
    @Operation(summary = "Get Insurer Settings", description = "Retrieve insurer or agency settings")
    @ApiResponse(responseCode = "200", description = "Settings retrieved successfully")
    public ResponseEntity<InsurerSettingsSchema> getInsurerSettings(
            @Parameter(description = "Agency ID") 
            @RequestParam(value = "agency", required = false) String agency
    ) {
        InsurerSettingsSchema result = insurersService.getInsurerSettings(agency);
        return ResponseEntity.ok(result);
    }

    // ============ Insured API ============
    @GetMapping("/insureds")
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

    @DeleteMapping("/insureds/{insured}")
    @Operation(summary = "Delete Insured", description = "Delete an insured record")
    @ApiResponse(responseCode = "200", description = "Insured deleted successfully")
    public ResponseEntity<InsuredsDeleteSchema> deleteInsured(
            @Parameter(description = "Insured UUID") 
            @PathVariable String insured
    ) {
        InsuredsDeleteSchema result = insurersService.deleteInsured(insured);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/insureds/{insured}")
    @Operation(summary = "Read Insured", description = "Get specific insured details")
    @ApiResponse(responseCode = "200", description = "Insured details retrieved successfully")
    public ResponseEntity<InsuredReadSchema> readInsured(
            @Parameter(description = "Insured UUID") 
            @PathVariable String insured
    ) {
        InsuredReadSchema result = insurersService.readInsured(insured);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/insureds/{insured}")
    @Operation(summary = "Create/Update Insured", description = "Create or update an insured record")
    @ApiResponse(responseCode = "200", description = "Insured created/updated successfully")
    public ResponseEntity<InsuredsCreateSchema> createInsured(
            @Parameter(description = "Insured UUID") 
            @PathVariable String insured,
            @RequestBody InsuredSourceSchema request
    ) {
        InsuredsCreateSchema result = insurersService.createInsured(insured, request);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/insureds/{insured}/reprofile")
    @Operation(summary = "Reprofile Insured", description = "Trigger reprofile for an insured")
    @ApiResponse(responseCode = "200", description = "Reprofile initiated successfully")
    public ResponseEntity<InsuredsReprofileSchema> reProfileInsured(
            @Parameter(description = "Insured UUID") 
            @PathVariable String insured
    ) {
        InsuredsReprofileSchema result = insurersService.reProfileInsured(insured);
        return ResponseEntity.ok(result);
    }

    // ============ Aggregated Risk API ============
    @GetMapping("/aggregated-risk")
    @Operation(summary = "Get Aggregated Risk", description = "Retrieve aggregated risk report")
    @ApiResponse(responseCode = "200", description = "Aggregated risk retrieved successfully")
    public ResponseEntity<AggregatedRiskSchema> getAggregatedRisk(
            @Parameter(description = "Book to filter")
            @RequestParam(value = "book", required = false) String book,
            @Parameter(description = "Agency ID to filter")
            @RequestParam(value = "agency", required = false) String agency,
            @Parameter(description = "Start date filter")
            @RequestParam(value = "start_date", required = false) String startDate,
            @Parameter(description = "End date filter")
            @RequestParam(value = "end_date", required = false) String endDate
    ) {
        AggregatedRiskSchema result = insurersService.getAggregatedRisk(book, agency, startDate, endDate);
        return ResponseEntity.ok(result);
    }

    // ============ Reports API ============
    @GetMapping("/reports")
    @Operation(summary = "Get Report Snapshots", description = "Get all report snapshots for insurer")
    @ApiResponse(responseCode = "200", description = "Report snapshots retrieved successfully")
    public ResponseEntity<SnapshotsListSchema> getReportSnapshots(
            @Parameter(description = "Get snapshots since date")
            @RequestParam(value = "since", required = false) String since,
            @Parameter(description = "Number of items per page")
            @RequestParam(value = "limit", defaultValue = "100") int limit,
            @Parameter(description = "Number of items to skip")
            @RequestParam(value = "skip", defaultValue = "0") int skip
    ) {
        SnapshotsListSchema result = insurersService.getReportSnapshots(since, limit, skip);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/reports/insureds/{insured}")
    @Operation(summary = "Get Report Snapshots by Insured", description = "Get report snapshots for specific insured")
    @ApiResponse(responseCode = "200", description = "Insured report snapshots retrieved successfully")
    public ResponseEntity<SnapshotsListSchema> getReportSnapshotsByInsured(
            @Parameter(description = "Insured UUID")
            @PathVariable String insured,
            @Parameter(description = "Get snapshots since date")
            @RequestParam(value = "since", required = false) String since,
            @Parameter(description = "Number of items per page")
            @RequestParam(value = "limit", defaultValue = "100") int limit,
            @Parameter(description = "Number of items to skip")
            @RequestParam(value = "skip", defaultValue = "0") int skip
    ) {
        SnapshotsListSchema result = insurersService.getReportSnapshotsByInsured(insured, since, limit, skip);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/reports/insureds/{insured}/{snapshot}")
    @Operation(summary = "Get Report Snapshot", description = "Get specific report snapshot")
    @ApiResponse(responseCode = "200", description = "Report snapshot retrieved successfully")
    public ResponseEntity<SnapshotSchema> getReportSnapshot(
            @Parameter(description = "Insured UUID")
            @PathVariable String insured,
            @Parameter(description = "Snapshot ID or 'last'")
            @PathVariable String snapshot
    ) {
        SnapshotSchema result = insurersService.getReportSnapshot(insured, snapshot);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/reports/insureds/{insured}/{snapshot}/full-version")
    @Operation(summary = "Get Full Report Snapshot", description = "Get full report snapshot with recommendations")
    @ApiResponse(responseCode = "200", description = "Full report snapshot retrieved successfully")
    public ResponseEntity<SnapshotFullSchema> getReportSnapshotFullVersion(
            @Parameter(description = "Insured UUID")
            @PathVariable String insured,
            @Parameter(description = "Snapshot ID or 'last'")
            @PathVariable String snapshot
    ) {
        SnapshotFullSchema result = insurersService.getReportSnapshotFullVersion(insured, snapshot);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/reports/insureds/{insured}/{snapshot}/export-pdf")
    @Operation(summary = "Export Report Snapshot PDF", description = "Export report snapshot as PDF with customizable options")
    @ApiResponse(responseCode = "200", description = "PDF exported successfully", content = @Content(mediaType = "application/pdf"))
    public ResponseEntity<Resource> exportReportSnapshotPdf(
            @Parameter(description = "Insured UUID")
            @PathVariable String insured,
            @Parameter(description = "Snapshot ID or 'last'")
            @PathVariable String snapshot,
            @RequestHeader(value = "Accept", defaultValue = "application/pdf") String accept,
            @Parameter(description = "Show underwriting screen")
            @RequestParam(value = "show-underwriting-screen", required = false) Boolean showUnderwritingScreen,
            @Parameter(description = "Show data screen")
            @RequestParam(value = "show-data-screen", required = false) Boolean showDataScreen,
            @Parameter(description = "Show recommendations screen")
            @RequestParam(value = "show-recommendations-screen", required = false) Boolean showRecommendationsScreen,
            @Parameter(description = "Show regulatory frameworks")
            @RequestParam(value = "show-regulatory-frameworks", required = false) Boolean showRegulatoryFrameworks,
            @Parameter(description = "Show coverage description screen")
            @RequestParam(value = "show-coverage-description-screen", required = false) Boolean showCoverageDescriptionScreen,
            @Parameter(description = "Show risk report explanation screen")
            @RequestParam(value = "show-risk-report-explanation-screen", required = false) Boolean showRiskReportExplanationScreen,
            @Parameter(description = "Show security questionnaire screen")
            @RequestParam(value = "show-security-questionnaire-screen", required = false) Boolean showSecurityQuestionnaireScreen,
            @Parameter(description = "Show risk report summary custom screen")
            @RequestParam(value = "show-risk-report-summary-custom-screen", required = false) Boolean showRiskReportSummaryCustomScreen,
            @Parameter(description = "Language of the report")
            @RequestParam(value = "lang", required = false) String lang,
            @Parameter(description = "Currency of the report")
            @RequestParam(value = "currency", required = false) String currency
    ) {
        Resource result = insurersService.exportReportSnapshotPdf(insured, snapshot, accept, showUnderwritingScreen, showDataScreen, showRecommendationsScreen, showRegulatoryFrameworks, showCoverageDescriptionScreen, showRiskReportExplanationScreen, showSecurityQuestionnaireScreen, showRiskReportSummaryCustomScreen, lang, currency);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(result);
    }

    @GetMapping("/reports/insureds/{insured}/{snapshot}/export-custom-pdf")
    @Operation(summary = "Export Custom PDF", description = "Export custom PDF for report snapshot")
    @ApiResponse(responseCode = "200", description = "Custom PDF exported successfully", content = @Content(mediaType = "application/pdf"))
    public ResponseEntity<Resource> exportReportSnapshotCustomPdf(
            @Parameter(description = "Insured UUID")
            @PathVariable String insured,
            @Parameter(description = "Snapshot ID or 'last'")
            @PathVariable String snapshot,
            @RequestHeader(value = "Accept", defaultValue = "application/pdf") String accept
    ) {
        Resource result = insurersService.exportReportSnapshotCustomPdf(insured, snapshot, accept);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(result);
    }
}

