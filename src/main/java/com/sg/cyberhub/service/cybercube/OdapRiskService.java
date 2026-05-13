package com.sg.cyberhub.service.cybercube;

import com.sg.cyberhub.client.cybercube.OdapRiskApiClient;
import com.sg.cyberhub.model.cybercube.risk.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OdapRiskService {

    private final OdapRiskApiClient client;

    public UUID createAccount(CreateAccountV3Dto request) {
        return client.createCompanyV3(request).getAccountId();
    }

    public CreateAccountV3Dto getAccount(UUID accountId) {
        return client.getCompanyV3(accountId);
    }

    public UUID runAnalysis(UUID accountId) {
        return client.runAnalysisLatest(accountId).getAnalysisId();
    }

    public LatestMonthAnalysisDataV3Dto getRiskScores(UUID accountId, UUID analysisId) {
        return client.getRiskScoresV3(accountId, analysisId);
    }

    public AmAnalysisReportDto getFullReport(UUID accountId, UUID analysisId) {
        return client.downloadReportLatest(accountId, analysisId);
    }

    public SecuritySignalsResponseDto getSecuritySignals(
            UUID accountId,
            UUID analysisId,
            String threatType,
            String signalType,
            String signalImpact,
            String signalState
    ) {
        return client.getSecuritySignals(accountId, analysisId, threatType, signalType, signalImpact, signalState);
    }

    public SecuritySignalsHistoricalResponse getHistoricalSignals(
            UUID accountId,
            UUID analysisId,
            String signalName,
            Integer months
    ) {
        return client.getHistoricalSignals(accountId, analysisId, signalName, months);
    }

    public List<SearchCompanyDto> searchCompany(String query) {
        return client.searchCompany(query);
    }
}