package io.digitalready.accounts.common.model;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class ApiResponse<T> {
    protected String status;
    protected T data;
    protected List<ApiError> errors;

    public static <T> ApiResponse<T> success(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setStatus(Constants.SUCCESS);
        response.setData(data);
        return response;
    }

    public static ApiResponse<?> error(ApiError error) {
        ApiResponse<?> response = new ApiResponse<>();
        response.setErrors(Collections.singletonList(error));
        return response;
    }

}
