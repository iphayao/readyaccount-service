package io.digitalready.billary.common.model;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class ApiErrorResponse extends ApiResponse {
    private List<ApiError> errors;

    public ApiErrorResponse() {
        status = Constants.ERROR;
    }

    public static ApiErrorResponse of(List<ApiError> errors) {
        ApiErrorResponse response = new ApiErrorResponse();
        response.setErrors(errors);
        return response;
    }

    public static ApiErrorResponse of(ApiError error) {
        ApiErrorResponse response = new ApiErrorResponse();
        response.setErrors(Collections.singletonList(error));
        return response;
    }

}
