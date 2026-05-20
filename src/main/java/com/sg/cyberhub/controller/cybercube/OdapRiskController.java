package com.sg.cyberhub.controller.cybercube;

import com.sg.cyberhub.model.cybercube.risk.*;
import com.sg.cyberhub.service.cybercube.OdapRiskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cybercube/odap/risk")
@RequiredArgsConstructor
@Tag(name = "Cyber Cube Risk API", description = "Operations for CyberCube Risk Scoring")
public class OdapRiskController {

    private final OdapRiskService service;

    @PostMapping("/accounts")
    @Operation(summary = "Create Account", description = "Creates a new account and returns accountId")
    public UUID createAccount(@RequestBody CreateAccountV3Dto request) {
        return service.createAccount(request);
    }

    @GetMapping("/accounts/{accountId}")
    @Operation(summary = "Get Account", description = "Retrieve account details by accountId")
    public Mono<CreateAccountV3Dto> getAccount(
            @Parameter(description = "Account ID", required = true)
            @PathVariable UUID accountId
    ) {
        return service.getAccount(accountId);
    }

    @PostMapping("/accounts/{accountId}/analyses")
    @Operation(summary = "Run Analysis", description = "Runs risk scoring analysis for an account")
    public UUID runAnalysis(
            @Parameter(description = "Account ID", required = true)
            @PathVariable UUID accountId
    ) {
        return service.runAnalysis(accountId);
    }

    @GetMapping("/accounts/{accountId}/analyses/{analysisId}/scores")
    @Operation(summary = "Get Risk Scores", description = "Retrieve risk scores for an analysis")
    public Mono<LatestMonthAnalysisDataV3Dto> getRiskScores(
            @Parameter(description = "Account ID", required = true)
            @PathVariable UUID accountId,
            @Parameter(description = "Analysis ID", required = true)
            @PathVariable UUID analysisId
    ) {
        return service.getRiskScores(accountId, analysisId);
    }

    @GetMapping("/accounts/{accountId}/analyses/{analysisId}/report")
    @Operation(summary = "Download Report", description = "Get presigned URL for full report")
    public Mono<AmAnalysisReportDto> getFullReport(
            @Parameter(description = "Account ID", required = true)
            @PathVariable UUID accountId,
            @Parameter(description = "Analysis ID", required = true)
            @PathVariable UUID analysisId
    ) {
        return service.getFullReport(accountId, analysisId);
    }

    @GetMapping("/accounts/{accountId}/analyses/{analysisId}/signals")
    @Operation(summary = "Get Security Signals", description = "Retrieve filtered security signals")
    public Mono<SecuritySignalsResponseDto> getSecuritySignals(
            @Parameter(description = "Account ID", required = true)
            @PathVariable UUID accountId,
            @Parameter(description = "Analysis ID", required = true)
            @PathVariable UUID analysisId,
            @Parameter(description = "Threat Type")
            @RequestParam(required = false) String threatType,
            @Parameter(description = "Signal Type")
            @RequestParam(required = false) String signalType,
            @Parameter(description = "Signal Impact")
            @RequestParam(required = false) String signalImpact,
            @Parameter(description = "Signal State")
            @RequestParam(required = false) String signalState
    ) {
        return service.getSecuritySignals(accountId, analysisId, threatType, signalType, signalImpact, signalState);
    }

    @GetMapping("/accounts/{accountId}/analyses/{analysisId}/signals/history")
    @Operation(summary = "Get Historical Signals", description = "Retrieve historical signal trends")
    public Mono<SecuritySignalsHistoricalResponse> getHistoricalSignals(
            @Parameter(description = "Account ID", required = true)
            @PathVariable UUID accountId,
            @Parameter(description = "Analysis ID", required = true)
            @PathVariable UUID analysisId,
            @Parameter(description = "Signal Name")
            @RequestParam(required = false) String signalName,
            @Parameter(description = "Months (1-12)")
            @RequestParam(required = false) Integer months
    ) {
        return service.getHistoricalSignals(accountId, analysisId, signalName, months);
    }

    @GetMapping("/companies/search")
    @Operation(summary = "Search Company", description = "Search companies by name or website")
    public Mono<List<SearchCompanyDto>> searchCompany(
            @Parameter(description = "Search query", required = true)
            @RequestParam String query
    ) {
        return service.searchCompany(query);
    }
}