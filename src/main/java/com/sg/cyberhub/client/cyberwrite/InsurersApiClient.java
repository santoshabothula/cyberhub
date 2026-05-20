package com.sg.cyberhub.client.cyberwrite;

import com.sg.cyberhub.model.cyberwrite.insurers.*;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.*;
import reactor.core.publisher.Mono;

@HttpExchange(
        accept = "application/json",
        contentType = "application/json"
)
public interface InsurersApiClient {

    // ============ Insurer Settings API ============
    @GetExchange("/settings")
    Mono<InsurerSettingsSchema> getInsurerSettings(
            @RequestParam(value = "agency", required = false) String agency
    );

    // ============ Insured API ============
    @GetExchange("/insureds")
    Mono<InsuredsListSchema> searchInsureds(
            @RequestParam(value = "limit", defaultValue = "100") int limit,
            @RequestParam(value = "skip", defaultValue = "0") int skip,
            @RequestParam(value = "assigned_id", required = false) String assignedId,
            @RequestParam(value = "search", required = false) String search
    );

    @DeleteExchange("/insureds/{insured}")
    Mono<InsuredsDeleteSchema> deleteInsured(
            @PathVariable String insured
    );

    @GetExchange("/insureds/{insured}")
    Mono<InsuredReadSchema> readInsured(
            @PathVariable String insured
    );

    @PutExchange("/insureds/{insured}")
    Mono<InsuredsCreateSchema> createInsured(
            @PathVariable String insured,
            @RequestBody InsuredSourceSchema request
    );

    @PostExchange("/insureds/{insured}/reprofile")
    Mono<InsuredsReprofileSchema> reProfileInsured(
            @PathVariable String insured
    );

    // ============ Aggregated Risk API ============
    @GetExchange("/aggregated-risk")
    Mono<AggregatedRiskSchema> getAggregatedRisk(
            @RequestParam(value = "book", required = false) String book,
            @RequestParam(value = "agency", required = false) String agency,
            @RequestParam(value = "start_date", required = false) String startDate,
            @RequestParam(value = "end_date", required = false) String endDate
    );

    // ============ Reports API ============
    @GetExchange("/reports")
    Mono<SnapshotsListSchema> getReportSnapshots(
            @RequestParam(value = "since", required = false) String since,
            @RequestParam(value = "limit", defaultValue = "100") int limit,
            @RequestParam(value = "skip", defaultValue = "0") int skip
    );

    @GetExchange("/reports/insureds/{insured}")
    Mono<SnapshotsListSchema> getReportSnapshotsByInsured(
            @PathVariable String insured,
            @RequestParam(value = "since", required = false) String since,
            @RequestParam(value = "limit", defaultValue = "100") int limit,
            @RequestParam(value = "skip", defaultValue = "0") int skip
    );

    @GetExchange("/reports/insureds/{insured}/{snapshot}")
    Mono<SnapshotSchema> getReportSnapshot(
            @PathVariable String insured,
            @PathVariable String snapshot
    );

    @GetExchange("/reports/insureds/{insured}/{snapshot}/full-version")
    Mono<SnapshotFullSchema> getReportSnapshotFullVersion(
            @PathVariable String insured,
            @PathVariable String snapshot
    );

    @GetExchange("/reports/insureds/{insured}/{snapshot}/export-pdf")
    Mono<Resource> exportReportSnapshotPdf(
            @PathVariable String insured,
            @PathVariable String snapshot,
            @RequestHeader(value = "Accept", defaultValue = "application/pdf") String accept,
            @RequestParam(value = "show-underwriting-screen", required = false) Boolean showUnderwritingScreen,
            @RequestParam(value = "show-data-screen", required = false) Boolean showDataScreen,
            @RequestParam(value = "show-recommendations-screen", required = false) Boolean showRecommendationsScreen,
            @RequestParam(value = "show-regulatory-frameworks", required = false) Boolean showRegulatoryFrameworks,
            @RequestParam(value = "show-coverage-description-screen", required = false) Boolean showCoverageDescriptionScreen,
            @RequestParam(value = "show-risk-report-explanation-screen", required = false) Boolean showRiskReportExplanationScreen,
            @RequestParam(value = "show-security-questionnaire-screen", required = false) Boolean showSecurityQuestionnaireScreen,
            @RequestParam(value = "show-risk-report-summary-custom-screen", required = false) Boolean showRiskReportSummaryCustomScreen,
            @RequestParam(value = "lang", required = false) String lang,
            @RequestParam(value = "currency", required = false) String currency
    );

    @GetExchange("/reports/insureds/{insured}/{snapshot}/export-custom-pdf")
    Mono<Resource> exportReportSnapshotCustomPdf(
            @PathVariable String insured,
            @PathVariable String snapshot,
            @RequestHeader(value = "Accept", defaultValue = "application/pdf") String accept
    );
}
