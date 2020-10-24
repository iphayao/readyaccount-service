package io.digitalready.accounts.product.model;

import lombok.Data;

import java.math.BigDecimal;

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
