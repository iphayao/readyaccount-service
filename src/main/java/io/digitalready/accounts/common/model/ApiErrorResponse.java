package io.digitalready.accounts.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ApiErrorResponse extends ApiResponse {
    private List<ApiError> errors;

    public ApiErrorResponse() {
        status = Constants.ERROR;
    }

    public static ApiErrorResponse of(ApiError error) {
        ApiErrorResponse response = new ApiErrorResponse();
        response.setErrors(Collections.singletonList(error));
        return response;
    }

}
