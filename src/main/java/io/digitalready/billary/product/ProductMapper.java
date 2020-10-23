package io.digitalready.billary.product;

import io.digitalready.billary.product.model.Product;
import io.digitalready.billary.product.model.ProductReq;
import io.digitalready.billary.product.model.ProductRes;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(ProductReq productReq);
    ProductRes toProductRes(Product product);
    void copy(Product source, @MappingTarget Product target);

}
