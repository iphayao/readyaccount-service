package io.digitalready.accounts.contact.model;

public enum PersonType {
    NATURAL(0),
    LEGAL(1);

    public final int val;

    PersonType(int val) {
        this.val = val;
    }
}
