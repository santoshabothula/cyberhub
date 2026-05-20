package com.sg.cyberhub.service.cybercube;

import com.sg.cyberhub.client.cybercube.OdapRiskApiClient;
import com.sg.cyberhub.model.cybercube.risk.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OdapRiskService {

    private final OdapRiskApiClient client;

    public UUID createAccount(CreateAccountV3Dto request) {
        return Objects.requireNonNull(client.createCompanyV3(request).block()).getAccountId();
    }

    public Mono<CreateAccountV3Dto> getAccount(UUID accountId) {
        return client.getCompanyV3(accountId);
    }

    public UUID runAnalysis(UUID accountId) {
        return Objects.requireNonNull(client.runAnalysisLatest(accountId).block()).getAnalysisId();
    }

    public Mono<LatestMonthAnalysisDataV3Dto> getRiskScores(UUID accountId, UUID analysisId) {
        return client.getRiskScoresV3(accountId, analysisId);
    }

    public Mono<AmAnalysisReportDto> getFullReport(UUID accountId, UUID analysisId) {
        return client.downloadReportLatest(accountId, analysisId);
    }

    public Mono<SecuritySignalsResponseDto> getSecuritySignals(
            UUID accountId,
            UUID analysisId,
            String threatType,
            String signalType,
            String signalImpact,
            String signalState
    ) {
        return client.getSecuritySignals(accountId, analysisId, threatType, signalType, signalImpact, signalState);
    }

    public Mono<SecuritySignalsHistoricalResponse> getHistoricalSignals(
            UUID accountId,
            UUID analysisId,
            String signalName,
            Integer months
    ) {
        return client.getHistoricalSignals(accountId, analysisId, signalName, months);
    }

    public Mono<List<SearchCompanyDto>> searchCompany(String query) {
        return client.searchCompany(query);
    }
}