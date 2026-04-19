package com.sg.cyberhub.controller.cybercube;

import com.sg.cyberhub.model.cybercube.fl.*;
import com.sg.cyberhub.service.cybercube.OdapFlService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/cybercube/odap/fl")
@Tag(name = "Cyber Cube Financial Loss API", description = "")
public class OdapFlController {

    private OdapFlService service;

    @PostMapping("/accounts")
    @Operation(summary = "Create Account", description = "Create a new account. Use the returned `accountId` in other endpoints to identify the account.")
    @ApiResponse(responseCode = "200", description = "Ok")
    public Account createAnAccount(@RequestBody Accountv3Request request) {
        return service.createAnAccount(request);
    }

    @GetMapping("/financial-loss/accounts/{accountId}/analyses/{analysisId}/cat-losses")
    @Operation(summary = "Get CAT Financial Loss", description = "Use an `accountId` and `analysisId` to get CAT financial loss data for an account:   - Expected Loss   - Average Frequency   - Average Severity   - Coefficient of Variation   - Standard Deviation   - Probability of Attachment   - Probability of Exhaustion   - Modelled Loss Ratio")
    @ApiResponse(responseCode = "200", description = "Ok")
    public FinancialLossResults getCATFinancialLoss(@PathVariable String accountId, @PathVariable String analysisId) {
        return service.getCATFinancialLoss(accountId, analysisId);
    }

    @GetMapping("financial-loss/accounts/{accountId}/analyses/{analysisId}/cat-report")
    @Operation(summary = "Download CAT Financial Loss Report", description = "Get a `preSignedUrl` to download a CSV report with CAT financial loss data by using an `accountId` and `analysisId`. Keep in mind that your `preSignedUrl` is valid for 5 minutes.  Download the report with a GET command and the `preSignedUrl`. See [Export a Report](/financial-loss-apis/exporting-a-report)  for example code.  **Note:** Wait at least 30 seconds before exporting a report from an analysis.")
    @ApiResponse(responseCode = "200", description = "Ok")
    public FinancialLossResultsYlt getCATYLTPresignedURL(@PathVariable String accountId, @PathVariable String analysisId) {
        return service.getCATYLTPresignedURL(accountId, analysisId);
    }

    @GetMapping("financial-loss/accounts/{accountId}/analyses/{analysisId}/attritional-losses/{type}")
    @Operation(summary = "Get Financial Loss by Type", description = "Use an `accountId` and `analysisId` to get financial loss data by type. Enter `Risk_Adjusted` or `Baseline` to determine the calculation type for the loss metrics:   - Expected Loss   - Average Frequency   - Average Severity   - Coefficient of Variation   - Standard Deviation   - Probability of Attachment   - Probability of Exhaustion   - Modelled Loss Ratio")
    @ApiResponse(responseCode = "200", description = "Ok")
    public FinancialLossResults getFinancialLossByTypeRiskAdjustedBaseline(@PathVariable String accountId, @PathVariable String analysisId, @PathVariable String type) {
        return service.getFinancialLossByTypeRiskAdjustedBaseline(accountId, analysisId, type);
    }

    @GetMapping("financial-loss/accounts/{accountId}/analyses/{analysisId}/attritional-reports/{type}")
    @Operation(summary = "Download Financial Loss by Type Report", description = "Get a `preSignedUrl` to download a CSV report with financial loss data by type (RFA, baseline) by using an `accountId` and `analysisId`. Keep in mind that your `preSignedUrl` is valid for 5 minutes.  Download the report with a GET command and the `preSignedUrl`. See [Export a Report](/financial-loss-apis/exporting-a-report)  for example code.  **Note:** Wait at least 30 seconds before exporting a report from an analysis.")
    @ApiResponse(responseCode = "200", description = "Ok")
    public FinancialLossResultsYlt getYLTPresignedURLResultByTypeRFABASELINE(@PathVariable String accountId, @PathVariable String analysisId, @PathVariable String type) {
        return service.getYLTPresignedURLResultByTypeRFABASELINE(accountId, analysisId, type);
    }

    @GetMapping("/accounts/{accountId}")
    @ApiResponse(responseCode = "200", description = "Ok")
    @Operation(summary = "View Account", description = "View information for an account by using an `accountID`.")
    public Accountv3Request retrieveAccountInformation(@PathVariable String accountId) {
        return service.retrieveAccountInformation(accountId);
    }

    @PostMapping("/accounts/{accountId}/analyses")
    @Operation(summary = "Run Financial Loss Analysis", description = "Run a Financial Loss Analysis using an `accountId`. Use the returned `analysisId` in other endpoints to get financial loss data and reports.   ***Note:*** This endpoint does not download the report or show the data. Wait at least **30 seconds** before exporting a report from the analysis.")
    @ApiResponse(responseCode = "200", description = "Ok")
    public RunAnalysisResponse runAnalysis(@PathVariable String accountId) {
        return service.runAnalysis(accountId);
    }

    @GetMapping("/search")
    @ApiResponse(responseCode = "200", description = "Ok")
    @Operation(summary = "Find Company", description = "Search for available companies in our firmographic database. You can search by company name or website:    - Searches for names and websites are not case-sensitive.   - Website prefix (https:// or http://) is not required.   - Searches return up to 50 matching company records.")
    public Accountv3Request searchCompany(@RequestParam String query) {
        return service.searchCompany(query);
    }
}
