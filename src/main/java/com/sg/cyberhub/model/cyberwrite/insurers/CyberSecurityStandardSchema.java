
package com.sg.cyberhub.model.cyberwrite.insurers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CyberSecurityStandardSchema {

    @JsonProperty("aicpa")
    private String aicpa;

    @JsonProperty("eudpd")
    private String eudpd;

    @jakarta.validation.constraints.NotBlank
    @JsonProperty("finding_type")
    private String findingType;

    @JsonProperty("iso_27001")
    private String iso27001;

    @JsonProperty("iso_27017")
    private String iso27017;

    @JsonProperty("nist_sp800")
    private String nistSp800;

    @JsonProperty("pci_dss_v30")
    private String pciDssV30;

    @JsonProperty("pci_dss_v32")
    private String pciDssV32;

    @JsonProperty("shared_assesments")
    private String sharedAssesments;


}

