package com.sg.cyberhub.service.cybercube;

import com.sg.cyberhub.client.cybercube.OdapApiFlClient;
import com.sg.cyberhub.model.cybercube.fl.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@AllArgsConstructor
public class OdapFlService {

    private OdapApiFlClient client;

    public Mono<Account> createAnAccount(Accountv3Request request) {
        return client.createAnAccount(request);
    }

    public Mono<FinancialLossResults> getCATFinancialLoss(String accountId, String analysisId) {
        return client.getCATFinancialLoss(accountId, analysisId);
    }

    public Mono<FinancialLossResultsYlt> getCATYLTPresignedURL(String accountId, String analysisId) {
        return client.getCATYLTPresignedURL(accountId, analysisId);
    }

    public Mono<FinancialLossResults> getFinancialLossByTypeRiskAdjustedBaseline(String accountId, String analysisId, String type) {
        return client.getFinancialLossByTypeRiskAdjustedBaseline(accountId, analysisId, type);
    }

    public Mono<FinancialLossResultsYlt> getYLTPresignedURLResultByTypeRFABASELINE(String accountId, String analysisId, String type) {
        return client.getYLTPresignedURLResultByTypeRFABASELINE(accountId, analysisId, type);
    }

    public Mono<Accountv3Request> retrieveAccountInformation(String accountId) {
        return client.retrieveAccountInformation(accountId);
    }

    public Mono<RunAnalysisResponse> runAnalysis(String accountId) {
        return client.runAnalysis(accountId);
    }

    public Mono<List<SearchCompanyDto>> searchCompany(String query) {
        return client.searchCompany(query);
    }
}
