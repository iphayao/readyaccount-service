package io.digitalready.accounts.contact.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Data
public class Contract {
    @Id
    private Long id;
    private ContractType type;
    private PersonType personType;
    private String code;
    private String name;
    private String address;
    private String zipCode;
    private String taxId;
    private String branchCode;
    private String branch;
    private String person;
    private String email;
    private String mobile;
    private String bankId;
    private String bankAccountNumber;
    private String bankBranch;
    private String bankAccountType;
    private String creditDays;
    private String phone;
    private String fax;
    private String website;
    private String shippingAddress;
    private String note;
    private Long companyId;
    private Timestamp updatedDate;
    private Timestamp createdDate;
}
