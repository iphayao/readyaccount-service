package io.digitalready.accounts.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ApiException extends RuntimeException {
    private String code;

    public ApiException(String code, String message) {
        super(message);
        this.code = code;
    }

}
