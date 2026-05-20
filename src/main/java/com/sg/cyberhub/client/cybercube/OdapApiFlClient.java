package com.sg.cyberhub.client.cybercube;

import com.sg.cyberhub.model.cybercube.fl.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@HttpExchange(
        accept = "application/json",
        contentType = "application/json"
)
public interface OdapApiFlClient {

    @PostExchange("/risk-scoring/v3/accounts")
    Mono<Account> createAnAccount(@RequestBody Accountv3Request request);

    @GetExchange("/risk-scoring/v1/financial-loss/accounts/{accountId}/analyses/{analysisId}/cat-losses")
    Mono<FinancialLossResults> getCATFinancialLoss(@PathVariable String accountId, @PathVariable String analysisId);

    @GetExchange("/risk-scoring/v1/financial-loss/accounts/{accountId}/analyses/{analysisId}/cat-report")
    Mono<FinancialLossResultsYlt> getCATYLTPresignedURL(@PathVariable String accountId, @PathVariable String analysisId);

    @GetExchange("/risk-scoring/v1/financial-loss/accounts/{accountId}/analyses/{analysisId}/attritional-losses/{type}")
    Mono<FinancialLossResults> getFinancialLossByTypeRiskAdjustedBaseline(
            @PathVariable String accountId, @PathVariable String analysisId, @PathVariable String type
    );

    @GetExchange("/risk-scoring/v1/financial-loss/accounts/{accountId}/analyses/{analysisId}/attritional-reports/{type}")
    Mono<FinancialLossResultsYlt> getYLTPresignedURLResultByTypeRFABASELINE(
            @PathVariable String accountId, @PathVariable String analysisId, @PathVariable String type
    );

    @GetExchange("/risk-scoring/v3/accounts/{accountId}")
    Mono<Accountv3Request> retrieveAccountInformation(@PathVariable String accountId);

    @PostExchange("/risk-scoring/v3/accounts/{accountId}/analyses")
    Mono<RunAnalysisResponse> runAnalysis(@PathVariable String accountId);

    @GetExchange("/data/companies/v1/search")
    Mono<List<SearchCompanyDto>> searchCompany(@RequestParam String query);
}
