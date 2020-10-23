package io.digitalready.billary.product.model;

import io.digitalready.billary.product.ProductType;
import io.digitalready.billary.product.VatType;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Product {
    @Id
    private UUID id;
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
