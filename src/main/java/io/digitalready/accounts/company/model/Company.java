package io.digitalready.accounts.company.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Data
public class Company {
    @Id
    private Long id;
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
    private Timestamp updatedDate;
    private Timestamp createdDate;
}
