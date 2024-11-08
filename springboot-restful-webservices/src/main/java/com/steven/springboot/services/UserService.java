package com.steven.springboot.services;

import com.steven.springboot.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUser();

    User updateUser(User user);

    void deleteUser(Long id);
}
