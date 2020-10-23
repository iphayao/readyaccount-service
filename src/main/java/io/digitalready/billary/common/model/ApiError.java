package io.digitalready.billary.common.model;

import io.digitalready.billary.common.exception.ApiException;
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
