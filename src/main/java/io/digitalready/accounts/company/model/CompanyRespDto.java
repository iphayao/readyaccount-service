package io.digitalready.accounts.company.model;

import lombok.Data;

@Data
public class CompanyRespDto {
    private String type;
    private String name;
    private String nameEn;
    private String address;
    private String addressEn;
    private String zipCode;
    private String taxId;
    private String branch;
    private String branchEn;
    private String phone;
    private String mobile;
    private String fax;
    private String website;
}
