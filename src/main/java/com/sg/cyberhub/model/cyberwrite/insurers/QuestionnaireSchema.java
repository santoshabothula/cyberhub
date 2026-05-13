
package com.sg.cyberhub.model.cyberwrite.insurers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionnaireSchema {

    @jakarta.validation.constraints.NotNull
    @JsonProperty("annual_revenue")
    private Number annualRevenue;

    @JsonProperty("business_data_value")
    private Number businessDataValue;

    @JsonProperty("credit_data_value")
    private Number creditDataValue;

    @JsonProperty("financial_data_value")
    private Number financialDataValue;

    @JsonProperty("full_time_employee_count")
    private Number fullTimeEmployeeCount;

    @JsonProperty("has_antivirus")
    private Boolean hasAntivirus;

    @JsonProperty("has_backup")
    private Boolean hasBackup;

    @JsonProperty("has_business_data")
    private Boolean hasBusinessData;

    @JsonProperty("has_credit_data")
    private Boolean hasCreditData;

    @JsonProperty("has_endpoint_protection")
    private Boolean hasEndpointProtection;

    @JsonProperty("has_experienced_incident")
    private Boolean hasExperiencedIncident;

    @JsonProperty("has_external_it_provider")
    private Boolean hasExternalItProvider;

    @JsonProperty("has_financial_data")
    private Boolean hasFinancialData;

    @JsonProperty("has_firewall")
    private Boolean hasFirewall;

    @JsonProperty("has_medical_data")
    private Boolean hasMedicalData;

    @JsonProperty("has_personal_data")
    private Boolean hasPersonalData;

    @JsonProperty("incident_cost")
    private Number incidentCost;

    @JsonProperty("incident_date")
    private OffsetDateTime incidentDate;

    @JsonProperty("is_third_party_relying_on_service")
    private Number isThirdPartyRelyingOnService;

    @JsonProperty("it_employee_count")
    private Number itEmployeeCount;

    @JsonProperty("medical_data_value")
    private Number medicalDataValue;

    @JsonProperty("percent_from_online")
    private Number percentFromOnline;

    @JsonProperty("percent_from_online_options")
    private Number percentFromOnlineOptions;

    @JsonProperty("personal_data_value")
    private Number personalDataValue;

    @JsonProperty("report_type")
    private String reportType;

    @JsonProperty("security_employee_count")
    private Number securityEmployeeCount;


}

