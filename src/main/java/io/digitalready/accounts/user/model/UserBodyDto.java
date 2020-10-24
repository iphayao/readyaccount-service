package io.digitalready.accounts.user.model;

import lombok.Data;

import java.util.List;

@Data
public class UserBodyDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<String> roles;
}
