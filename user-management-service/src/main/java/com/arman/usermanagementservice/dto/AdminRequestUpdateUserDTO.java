package com.arman.usermanagementservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AdminRequestUpdateUserDTO {
    private Boolean enabled;
    private Set<String> rolesToAdd;
    private Set<String> rolesToRemove;
}
