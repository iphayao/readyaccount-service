package io.digitalready.accounts.user;

import io.digitalready.accounts.user.model.User;
import io.digitalready.accounts.user.model.UserBodyDto;
import io.digitalready.accounts.user.model.UserRespDto;
import org.mapstruct.Mapper;

import java.util.Arrays;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserBodyDto dto);
    UserRespDto toDto(User entity);

    default String rolesMap(List<String> roles) {
        return String.join(",", roles);
    }

    default List<String> rolesMap(String roles) {
        return Arrays.asList(roles.split(","));
    }

}
