package io.digitalready.billary.common.model;

import lombok.Data;

@Data
public class ApiSuccessResponse<T> extends ApiResponse {
    private T data;

    public ApiSuccessResponse() {
        status = Constants.SUCCESS;
    }

    public static <T> ApiSuccessResponse<T> of(T data) {
        ApiSuccessResponse<T> response = new ApiSuccessResponse<>();
        response.setData(data);
        return response;
    }
}
