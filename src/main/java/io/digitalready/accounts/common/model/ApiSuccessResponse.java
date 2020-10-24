package io.digitalready.accounts.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
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
