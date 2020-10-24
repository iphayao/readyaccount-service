package io.digitalready.accounts.product.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class Product {
    @Id
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
    private Long companyId;
    private Timestamp updatedDate;
    private Timestamp createdDate;
}
