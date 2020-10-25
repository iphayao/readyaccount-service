package io.digitalready.accounts.contact;

import io.digitalready.accounts.contact.model.Contract;
import io.digitalready.accounts.contact.model.ContractBodyDto;
import io.digitalready.accounts.contact.model.ContractRespDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ContractMapper {

    Contract toEntity(ContractBodyDto dto);
    ContractRespDto toDto(Contract entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "companyId", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    void update(Contract source, @MappingTarget Contract target);

}
