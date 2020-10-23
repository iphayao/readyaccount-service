package io.digitalready.billary.common.exception;

import io.digitalready.billary.common.Constants;

public class ProductNotFoundException extends ApiException {

    public ProductNotFoundException(String productId) {
        super(Constants.ERROR_PRODUCT_NOT_FOUND, "Product ID '" + productId + "' not found");
    }

}
