package com.sg.cyberhub.client.cybercube;

import com.sg.cyberhub.model.cybercube.fl.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange(
        accept = "application/json",
        contentType = "application/json"
)
public interface OdapApiFlClient {

    @PostExchange("/risk-scoring/v3/accounts")
    Account createAnAccount(@RequestBody Accountv3Request request);

    @GetExchange("/risk-scoring/v1/financial-loss/accounts/{accountId}/analyses/{analysisId}/cat-losses")
    FinancialLossResults getCATFinancialLoss(@PathVariable String accountId, @PathVariable String analysisId);

    @GetExchange("/risk-scoring/v1/financial-loss/accounts/{accountId}/analyses/{analysisId}/cat-report")
    FinancialLossResultsYlt getCATYLTPresignedURL(@PathVariable String accountId, @PathVariable String analysisId);

    @GetExchange("/risk-scoring/v1/financial-loss/accounts/{accountId}/analyses/{analysisId}/attritional-losses/{type}")
    FinancialLossResults getFinancialLossByTypeRiskAdjustedBaseline(
            @PathVariable String accountId, @PathVariable String analysisId, @PathVariable String type
    );

    @GetExchange("/risk-scoring/v1/financial-loss/accounts/{accountId}/analyses/{analysisId}/attritional-reports/{type}")
    FinancialLossResultsYlt getYLTPresignedURLResultByTypeRFABASELINE(
            @PathVariable String accountId, @PathVariable String analysisId, @PathVariable String type
    );

    @GetExchange("/risk-scoring/v3/accounts/{accountId}")
    Accountv3Request retrieveAccountInformation(@PathVariable String accountId);

    @PostExchange("/risk-scoring/v3/accounts/{accountId}/analyses")
    RunAnalysisResponse runAnalysis(@PathVariable String accountId);

    @GetExchange("/data/companies/v1/search")
    Accountv3Request searchCompany(@RequestParam String query);
}
