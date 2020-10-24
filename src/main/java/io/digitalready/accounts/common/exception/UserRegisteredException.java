package io.digitalready.accounts.common.exception;

import io.digitalready.accounts.common.Constants;

public class UserRegisteredException extends ApiException {

    public UserRegisteredException(String email) {
        super(Constants.ERROR_EMAIL_REGISTERED, "Email " + email + " was registered");
    }

}
