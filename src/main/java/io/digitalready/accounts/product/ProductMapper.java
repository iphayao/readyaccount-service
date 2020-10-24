package io.digitalready.accounts.product;

import io.digitalready.accounts.product.model.Product;
import io.digitalready.accounts.product.model.ProductBodyDto;
import io.digitalready.accounts.product.model.ProductRespDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductBodyDto dto);
    ProductRespDto toDto(Product entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "companyId", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    void update(Product source, @MappingTarget Product target);

}
