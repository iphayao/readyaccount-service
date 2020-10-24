package io.digitalready.accounts.company;

import io.digitalready.accounts.company.model.Company;
import io.digitalready.accounts.company.model.CompanyBodyDto;
import io.digitalready.accounts.company.model.CompanyRespDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company toEntity(CompanyBodyDto dto);
    CompanyRespDto toDto(Company entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    void update(Company source, @MappingTarget Company target);

}
