
package com.sg.cyberhub.model.cyberwrite.insurers;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CollectedDataSchema {

    @JsonProperty("alexa_global_rank")
    private Number alexaGlobalRank;

    @JsonProperty("alexa_linking_websites_count")
    private String alexaLinkingWebsitesCount;

    @JsonProperty("alexa_page_view_count")
    private String alexaPageViewCount;

    @JsonProperty("alexa_views_by_country")
    private List<@Valid AlexaViewsByCountry> alexaViewsByCountry;

    @JsonProperty("alexa_website_loading_time")
    private String alexaWebsiteLoadingTime;

    @JsonProperty("anti_ddos_mitigation_implemented")
    private Boolean antiDdosMitigationImplemented;

    @JsonProperty("associated_domains")
    private List<String> associatedDomains;

    @JsonProperty("business_tags")
    private List<String> businessTags;

    @JsonProperty("countries")
    private List<String> countries;

    @JsonProperty("crunchbase_handle")
    private String crunchbaseHandle;

    @JsonProperty("data_breach_registered_by_cyberwrite")
    private Number dataBreachRegisteredByCyberwrite;

    @JsonProperty("data_breach_reported_by_insured")
    private Boolean dataBreachReportedByInsured;

    @JsonProperty("dmarc_details")
    private String dmarcDetails;

    @JsonProperty("dmarc_implemented")
    private Boolean dmarcImplemented;

    @JsonProperty("email_security_providers")
    private List<String> emailSecurityProviders;

    @JsonProperty("estimated_annual_revenue")
    private Number estimatedAnnualRevenue;

    @JsonProperty("estimated_market_cap")
    private Number estimatedMarketCap;

    @JsonProperty("estimated_number_of_employees")
    private Number estimatedNumberOfEmployees;

    @JsonProperty("facebook_handle")
    private String facebookHandle;

    @JsonProperty("facebook_number_of_followers")
    private Number facebookNumberOfFollowers;

    @JsonProperty("glassdoor_average_rating")
    private BigDecimal glassdoorAverageRating;

    @JsonProperty("glassdoor_reviews_count")
    private Number glassdoorReviewsCount;

    @JsonProperty("google_search_total_results")
    private Number googleSearchTotalResults;

    @JsonProperty("hostnames")
    private List<String> hostnames;

    @Valid
    @JsonProperty("identified_technologies")
    private IdentifiedTechnologiesSchema identifiedTechnologies;

    @JsonProperty("incidents_date")
    private Map<String, Integer> incidentsDate;

    @JsonProperty("insured_logo_url")
    private String insuredLogoUrl;

    @JsonProperty("ip_addresses")
    private List<@Valid IPAddressSchema> ipAddresses;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("is_open_rdp")
    private Boolean isOpenRdp;

    @JsonProperty("leaked_clear_text_credentials_count")
    private Number leakedClearTextCredentialsCount;

    @JsonProperty("leaked_hashed_credentials_count")
    private Number leakedHashedCredentialsCount;

    @JsonProperty("leaked_weak_passwords_count")
    private Number leakedWeakPasswordsCount;

    @JsonProperty("linkedin_handle")
    private String linkedinHandle;

    @JsonProperty("malware_infections_count")
    private Number malwareInfectionsCount;

    @JsonProperty("malware_infections_description")
    private List<@Valid MalwareInfectionsDescriptionSchema> malwareInfectionsDescription;

    @JsonProperty("network_asns")
    private List<String> networkAsns;

    @Valid
    @JsonProperty("network_providers")
    private CoreTechnologiesSchema networkProviders;

    @JsonProperty("open_ports")
    private List<@Valid OpenPortSchema> openPorts;

    @JsonProperty("parent_domain")
    private String parentDomain;

    @JsonProperty("patch_cadence")
    private Number patchCadence;

    @JsonProperty("products_and_services")
    private List<String> productsAndServices;

    @jakarta.validation.constraints.NotNull
    @Valid
    @JsonProperty("risk_indicators")
    private RiskIndicatorsSchema riskIndicators;

    @Valid
    @JsonProperty("security_headers")
    private SecurityHeadersSchema securityHeaders;

    @JsonProperty("sic_code")
    private String sicCode;

    @JsonProperty("spf_details")
    private String spfDetails;

    @JsonProperty("spf_implemented")
    private Boolean spfImplemented;

    @JsonProperty("ssl_tls_certificates")
    private List<@Valid SslTlsCertificateSchema> sslTlsCertificates;

    @JsonProperty("ssl_tls_implemented")
    private Boolean sslTlsImplemented;

    @JsonProperty("ssl_tls_misconfigured")
    private Boolean sslTlsMisconfigured;

    @JsonProperty("ssl_vulnerabilities")
    private List<Object> sslVulnerabilities;

    @jakarta.validation.constraints.NotNull
    @JsonProperty("subdomains")
    private List<@Valid SubdomainSchema> subdomains;

    @JsonProperty("ticker_symbol")
    private String tickerSymbol;

    @JsonProperty("torrent_ip_address_count")
    private Number torrentIpAddressCount;

    @JsonProperty("twitter_followers_count")
    private Number twitterFollowersCount;

    @JsonProperty("twitter_following_count")
    private Number twitterFollowingCount;

    @JsonProperty("twitter_handle")
    private String twitterHandle;

    @JsonProperty("vertical_markets")
    private List<String> verticalMarkets;

    @JsonProperty("vulnerable_technologies")
    private Map<String, VulnerableTechSchema> vulnerableTechnologies;

    @JsonProperty("year_founded")
    private Number yearFounded;


}

