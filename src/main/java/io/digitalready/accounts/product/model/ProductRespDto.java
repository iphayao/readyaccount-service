package io.digitalready.accounts.product.model;

import io.digitalready.accounts.product.ProductType;
import io.digitalready.accounts.product.VatType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProductRespDto {
    private Long id;
    private ProductType type;
    private String name;
    private String code;
    private String description;
    private BigDecimal sellPrice;
    private BigDecimal sellPriceWithVat;
    private VatType sellVatType;
    private BigDecimal buyPrice;
    private BigDecimal buyPriceWithVat;
    private VatType buyVatType;
    private String unit;
    private String category;
    private String barcode;
    private int inventory;
}
