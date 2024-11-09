package com.steven.springboot.services;

import com.steven.springboot.dto.UserDTO;
import com.steven.springboot.entity.User;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO user);

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUser();

    UserDTO updateUser(UserDTO user);

    void deleteUser(Long id);
}
