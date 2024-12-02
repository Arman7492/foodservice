package com.arman.usermanagementservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserResponseDTO {
private long id;
private String name;
private String email;
private Set<String> roles;
}
