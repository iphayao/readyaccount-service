package io.digitalready.billary.common.exception;

import lombok.Data;

@Data
public class ApiException extends RuntimeException {
    private String code;

    public ApiException(String code, String message) {
        super(message);
        this.code = code;
    }

}
