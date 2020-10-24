package io.digitalready.accounts.common.exception;

import io.digitalready.accounts.common.Constants;

public class ProductNotFoundException extends ApiException {

    public ProductNotFoundException(String productId) {
        super(Constants.ERROR_PRODUCT_NOT_FOUND, "Product ID '" + productId + "' not found");
    }

}
