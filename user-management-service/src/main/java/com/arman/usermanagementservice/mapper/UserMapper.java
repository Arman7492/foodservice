package com.arman.usermanagementservice.mapper;

import com.arman.usermanagementservice.dto.UserRequestDTO;
import com.arman.usermanagementservice.dto.UserResponseDTO;
import com.arman.usermanagementservice.entity.Role;
import com.arman.usermanagementservice.entity.User;
import com.arman.usermanagementservice.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserMapper {
    private final RoleRepository roleRepository;

    public UserResponseDTO toUserResponseDTO(User user) {
        if(user == null) {
            return null;
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());

        userResponseDTO.setRoles(
                user.getRoles()
                        .stream()
                        .map(Role::getName)
                        .collect(Collectors.toSet())
        );

        return userResponseDTO;
    }

    public User toUser(UserRequestDTO userRequestDTO) {
        if(userRequestDTO == null) {
            return null;
        }

        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());

        if(userRequestDTO.getRoles() != null) {
            Set<Role> roles = userRequestDTO.getRoles().stream()
                    .map(roleName -> roleRepository.findByName(roleName).orElseThrow(() ->
                            new RuntimeException()))
                    .collect(Collectors.toSet());

            user.setRoles(roles);

        } else {
            Role defaultRole = roleRepository.findByName("ROLE_USER").orElseThrow(() ->
                    new RuntimeException());
            user.setRoles(Set.of(defaultRole));
        }
        return user;



    }
}
