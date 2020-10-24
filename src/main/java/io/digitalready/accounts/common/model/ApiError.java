package io.digitalready.accounts.common.model;

import io.digitalready.accounts.common.exception.ApiException;
import lombok.Data;

@Data
public class ApiError {
    private String code;
    private String desc;

    public static ApiError of(ApiException e) {
        ApiError error = new ApiError();
        error.setCode(e.getCode());
        error.setDesc(e.getMessage());
        return error;
    }
}
