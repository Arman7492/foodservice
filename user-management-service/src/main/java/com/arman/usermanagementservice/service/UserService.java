package com.arman.usermanagementservice.service;

import com.arman.usermanagementservice.dto.AdminRequestUpdateUserDTO;
import com.arman.usermanagementservice.dto.UserRequestDTO;
import com.arman.usermanagementservice.dto.UserResponseDTO;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO getUserById(Long id);
    void deleteUserById(Long id);
    void save(UserRequestDTO userRequestDTO);
    UserResponseDTO findByEmail(String email);
    boolean existsByEmail(String email);
    void updateUserByAdmin(Long id, AdminRequestUpdateUserDTO adminRequestUpdateUserDTO);
    void updateCurrentUser(String email, UserRequestDTO userRequestDTO);
}
