package io.digitalready.billary.product.model;

import io.digitalready.billary.product.ProductType;
import io.digitalready.billary.product.VatType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductReq {
    private ProductType type;
    private String code;
    private String name;
    private String description;
    private BigDecimal sellPrice;
    private VatType sellVatType;
    private String unit;
    private String category;
    private String barcode;
    private int inventory;
}
