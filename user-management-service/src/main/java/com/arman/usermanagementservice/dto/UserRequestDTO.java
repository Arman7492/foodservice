package com.arman.usermanagementservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
public class UserRequestDTO {
    private Long id;

    @NotBlank(message = "поле не может быть пустым")
    private String name;

    @Email(message = "некорректный формат email")
    @NotBlank(message = "email не может быть пустым")
    private String email;

    @NotBlank(message = "Пароль не может быть пустым")
    private String password;

    private Set<String> roles;
}