package com.sg.cyberhub.service.cybercube;

import com.sg.cyberhub.client.cybercube.OdapApiFlClient;
import com.sg.cyberhub.model.cybercube.fl.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OdapFlService implements OdapApiFlClient {

    private OdapApiFlClient client;

    @Override
    public Account createAnAccount(Accountv3Request request) {
        return client.createAnAccount(request);
    }

    @Override
    public FinancialLossResults getCATFinancialLoss(String accountId, String analysisId) {
        return client.getCATFinancialLoss(accountId, analysisId);
    }

    @Override
    public FinancialLossResultsYlt getCATYLTPresignedURL(String accountId, String analysisId) {
        return client.getCATYLTPresignedURL(accountId, analysisId);
    }

    @Override
    public FinancialLossResults getFinancialLossByTypeRiskAdjustedBaseline(String accountId, String analysisId, String type) {
        return client.getFinancialLossByTypeRiskAdjustedBaseline(accountId, analysisId, type);
    }

    @Override
    public FinancialLossResultsYlt getYLTPresignedURLResultByTypeRFABASELINE(String accountId, String analysisId, String type) {
        return client.getYLTPresignedURLResultByTypeRFABASELINE(accountId, analysisId, type);
    }

    @Override
    public Accountv3Request retrieveAccountInformation(String accountId) {
        return client.retrieveAccountInformation(accountId);
    }

    @Override
    public RunAnalysisResponse runAnalysis(String accountId) {
        return client.runAnalysis(accountId);
    }

    @Override
    public Accountv3Request searchCompany(String query) {
        return client.searchCompany(query);
    }
}
