package io.digitalready.billary.common.config;

import io.digitalready.billary.common.exception.ApiException;
import io.digitalready.billary.common.model.ApiError;
import io.digitalready.billary.common.model.ApiErrorResponse;
import io.digitalready.billary.common.model.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ApiResponse handleApiException(ApiException e) {
        return ApiErrorResponse.of(ApiError.of(e));
    }

}
