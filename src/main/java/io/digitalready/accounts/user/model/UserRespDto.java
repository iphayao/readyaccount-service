package io.digitalready.accounts.user.model;

import lombok.Data;

import java.util.List;

@Data
public class UserRespDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> roles;
}
