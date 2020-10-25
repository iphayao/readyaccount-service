package io.digitalready.accounts.common.config;

import io.digitalready.accounts.common.exception.ApiException;
import io.digitalready.accounts.common.model.ApiError;
import io.digitalready.accounts.common.model.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ApiResponse<?> handleApiException(ApiException e) {
        return ApiResponse.error(ApiError.of(e));
    }

}
