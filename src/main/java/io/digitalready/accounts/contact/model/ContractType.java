package io.digitalready.accounts.contact.model;

public enum ContractType {
    CUSTOMER(0),
    SELLER(1),
    CUSTOMER_SELLER(2);

    private final int val;

    ContractType(int val) {
        this.val = val;
    }
}
