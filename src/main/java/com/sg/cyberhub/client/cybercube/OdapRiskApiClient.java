package com.sg.cyberhub.client.cybercube;

import com.sg.cyberhub.model.cybercube.risk.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;
import java.util.UUID;

@HttpExchange(
        accept = "application/json",
        contentType = "application/json"
)
public interface OdapRiskApiClient {

    @PostExchange("/risk-scoring/v3/accounts")
    AccountIdDto createCompanyV3(@RequestBody CreateAccountV3Dto request);

    @GetExchange("/risk-scoring/v3/accounts/{accountId}")
    CreateAccountV3Dto getCompanyV3(@PathVariable UUID accountId);

    @PostExchange("/risk-scoring/v3/accounts/{accountId}/analyses")
    AnalysisIdDto runAnalysisLatest(@PathVariable UUID accountId);

    @GetExchange("/risk-scoring/v3/accounts/{accountId}/analyses/{analysisId}/scores")
    LatestMonthAnalysisDataV3Dto getRiskScoresV3(
            @PathVariable UUID accountId,
            @PathVariable UUID analysisId
    );

    @GetExchange("/risk-scoring/v3/accounts/{accountId}/analyses/{analysisId}/full-report")
    AmAnalysisReportDto downloadReportLatest(
            @PathVariable UUID accountId,
            @PathVariable UUID analysisId
    );

    @GetExchange("/risk-scoring/v1/security-signals/accounts/{accountId}/analyses/{analysisId}")
    SecuritySignalsResponseDto getSecuritySignals(
            @PathVariable UUID accountId,
            @PathVariable UUID analysisId,
            @RequestParam(required = false) String threatType,
            @RequestParam(required = false) String signalType,
            @RequestParam(required = false) String signalImpact,
            @RequestParam(required = false) String signalState
    );

    @GetExchange("/risk-scoring/v1/security-signals/historical-trends/accounts/{accountId}/analyses/{analysisId}")
    SecuritySignalsHistoricalResponse getHistoricalSignals(
            @PathVariable UUID accountId,
            @PathVariable UUID analysisId,
            @RequestParam(required = false) String signalName,
            @RequestParam(required = false) Integer months
    );

    @GetExchange("/data/companies/v1/search")
    List<SearchCompanyDto> searchCompany(@RequestParam String query);
}