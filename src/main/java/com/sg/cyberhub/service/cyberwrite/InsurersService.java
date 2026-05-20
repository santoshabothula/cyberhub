package com.sg.cyberhub.service.cyberwrite;

import com.sg.cyberhub.client.cyberwrite.InsurersApiClient;
import com.sg.cyberhub.model.cyberwrite.insurers.*;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class InsurersService {

    private InsurersApiClient client;

    public Mono<InsurerSettingsSchema> getInsurerSettings(String agency) {
        return client.getInsurerSettings(agency);
    }

    public Mono<InsuredsListSchema> searchInsureds(int limit, int skip, String assignedId, String search) {
        return client.searchInsureds(limit, skip, assignedId, search);
    }

    public Mono<InsuredsDeleteSchema> deleteInsured(String insured) {
        return client.deleteInsured(insured);
    }

    public Mono<InsuredReadSchema> readInsured(String insured) {
        return client.readInsured(insured);
    }

    public Mono<InsuredsCreateSchema> createInsured(String insured, InsuredSourceSchema request) {
        return client.createInsured(insured, request);
    }

    public Mono<InsuredsReprofileSchema> reProfileInsured(String insured) {
        return client.reProfileInsured(insured);
    }

    public Mono<AggregatedRiskSchema> getAggregatedRisk(String book, String agency, String startDate, String endDate) {
        return client.getAggregatedRisk(book, agency, startDate, endDate);
    }

    public Mono<SnapshotsListSchema> getReportSnapshots(String since, int limit, int skip) {
        return client.getReportSnapshots(since, limit, skip);
    }

    public Mono<SnapshotsListSchema> getReportSnapshotsByInsured(String insured, String since, int limit, int skip) {
        return client.getReportSnapshotsByInsured(insured, since, limit, skip);
    }

    public Mono<SnapshotSchema> getReportSnapshot(String insured, String snapshot) {
        return client.getReportSnapshot(insured, snapshot);
    }

    public Mono<SnapshotFullSchema> getReportSnapshotFullVersion(String insured, String snapshot) {
        return client.getReportSnapshotFullVersion(insured, snapshot);
    }

    public Mono<Resource> exportReportSnapshotPdf(String insured, String snapshot, String accept, Boolean showUnderwritingScreen, Boolean showDataScreen, Boolean showRecommendationsScreen, Boolean showRegulatoryFrameworks, Boolean showCoverageDescriptionScreen, Boolean showRiskReportExplanationScreen, Boolean showSecurityQuestionnaireScreen, Boolean showRiskReportSummaryCustomScreen, String lang, String currency) {
        return client.exportReportSnapshotPdf(insured, snapshot, accept, showUnderwritingScreen, showDataScreen, showRecommendationsScreen, showRegulatoryFrameworks, showCoverageDescriptionScreen, showRiskReportExplanationScreen, showSecurityQuestionnaireScreen, showRiskReportSummaryCustomScreen, lang, currency);
    }

    public Mono<Resource> exportReportSnapshotCustomPdf(String insured, String snapshot, String accept) {
        return client.exportReportSnapshotCustomPdf(insured, snapshot, accept);
    }
}
