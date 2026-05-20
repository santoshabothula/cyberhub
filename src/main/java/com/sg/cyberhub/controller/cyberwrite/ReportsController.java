package com.sg.cyberhub.controller.cyberwrite;

import com.sg.cyberhub.model.cyberwrite.insurers.SnapshotFullSchema;
import com.sg.cyberhub.model.cyberwrite.insurers.SnapshotSchema;
import com.sg.cyberhub.model.cyberwrite.insurers.SnapshotsListSchema;
import com.sg.cyberhub.service.cyberwrite.InsurersService;
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
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/cyberwrite/reports")
@AllArgsConstructor
@Tag(name = "Cyber Write Reports API", description = "API for managing insurers, insureds, and reports")
public class ReportsController {

    private InsurersService insurersService;

    @GetMapping
    @Operation(summary = "Get Report Snapshots", description = "Get all report snapshots for insurer")
    @ApiResponse(responseCode = "200", description = "Report snapshots retrieved successfully")
    public ResponseEntity<Mono<SnapshotsListSchema>> getReportSnapshots(
            @Parameter(description = "Get snapshots since date")
            @RequestParam(value = "since", required = false) String since,
            @Parameter(description = "Number of items per page")
            @RequestParam(value = "limit", defaultValue = "100") int limit,
            @Parameter(description = "Number of items to skip")
            @RequestParam(value = "skip", defaultValue = "0") int skip
    ) {
        return ResponseEntity.ok(insurersService.getReportSnapshots(since, limit, skip));
    }

    @GetMapping("/insureds/{insured}")
    @Operation(summary = "Get Report Snapshots by Insured", description = "Get report snapshots for specific insured")
    @ApiResponse(responseCode = "200", description = "Insured report snapshots retrieved successfully")
    public ResponseEntity<Mono<SnapshotsListSchema>> getReportSnapshotsByInsured(
            @Parameter(description = "Insured UUID")
            @PathVariable String insured,
            @Parameter(description = "Get snapshots since date")
            @RequestParam(value = "since", required = false) String since,
            @Parameter(description = "Number of items per page")
            @RequestParam(value = "limit", defaultValue = "100") int limit,
            @Parameter(description = "Number of items to skip")
            @RequestParam(value = "skip", defaultValue = "0") int skip
    ) {
        return ResponseEntity.ok(insurersService.getReportSnapshotsByInsured(insured, since, limit, skip));
    }

    @GetMapping("/insureds/{insured}/{snapshot}")
    @Operation(summary = "Get Report Snapshot", description = "Get specific report snapshot")
    @ApiResponse(responseCode = "200", description = "Report snapshot retrieved successfully")
    public ResponseEntity<Mono<SnapshotSchema>> getReportSnapshot(
            @Parameter(description = "Insured UUID")
            @PathVariable String insured,
            @Parameter(description = "Snapshot ID or 'last'")
            @PathVariable String snapshot
    ) {
        return ResponseEntity.ok(insurersService.getReportSnapshot(insured, snapshot));
    }

    @GetMapping("/insureds/{insured}/{snapshot}/full-version")
    @Operation(summary = "Get Full Report Snapshot", description = "Get full report snapshot with recommendations")
    @ApiResponse(responseCode = "200", description = "Full report snapshot retrieved successfully")
    public ResponseEntity<Mono<SnapshotFullSchema>> getReportSnapshotFullVersion(
            @Parameter(description = "Insured UUID")
            @PathVariable String insured,
            @Parameter(description = "Snapshot ID or 'last'")
            @PathVariable String snapshot
    ) {
        return ResponseEntity.ok(insurersService.getReportSnapshotFullVersion(insured, snapshot));
    }

    @GetMapping("/insureds/{insured}/{snapshot}/export-pdf")
    @Operation(summary = "Export Report Snapshot PDF", description = "Export report snapshot as PDF with customizable options")
    @ApiResponse(responseCode = "200", description = "PDF exported successfully", content = @Content(mediaType = "application/pdf"))
    public ResponseEntity<Mono<Resource>> exportReportSnapshotPdf(
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
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(insurersService.exportReportSnapshotPdf(insured, snapshot, accept, showUnderwritingScreen, showDataScreen, showRecommendationsScreen, showRegulatoryFrameworks, showCoverageDescriptionScreen, showRiskReportExplanationScreen, showSecurityQuestionnaireScreen, showRiskReportSummaryCustomScreen, lang, currency));
    }

    @GetMapping("/insureds/{insured}/{snapshot}/export-custom-pdf")
    @Operation(summary = "Export Custom PDF", description = "Export custom PDF for report snapshot")
    @ApiResponse(responseCode = "200", description = "Custom PDF exported successfully", content = @Content(mediaType = "application/pdf"))
    public ResponseEntity<Mono<Resource>> exportReportSnapshotCustomPdf(
            @Parameter(description = "Insured UUID")
            @PathVariable String insured,
            @Parameter(description = "Snapshot ID or 'last'")
            @PathVariable String snapshot,
            @RequestHeader(value = "Accept", defaultValue = "application/pdf") String accept
    ) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(insurersService.exportReportSnapshotCustomPdf(insured, snapshot, accept));
    }
}
