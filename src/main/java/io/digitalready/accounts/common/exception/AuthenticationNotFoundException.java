package io.digitalready.accounts.common.exception;

import io.digitalready.accounts.common.Constants;

public class AuthenticationNotFoundException extends ApiException {

    public AuthenticationNotFoundException() {
        super(Constants.ERROR_AUTHENTICATION_NOT_FOUND, "Authentication not found");
    }
}
