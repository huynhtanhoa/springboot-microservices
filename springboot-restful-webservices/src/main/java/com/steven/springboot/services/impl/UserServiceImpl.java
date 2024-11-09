package com.steven.springboot.services.impl;

import com.steven.springboot.dto.UserDTO;
import com.steven.springboot.entity.User;
import com.steven.springboot.mapper.UserMapper;
import com.steven.springboot.repository.UserRepository;
import com.steven.springboot.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        // convert DTO to JPA Entity
        User user = UserMapper.mapToUser(userDTO);

        User savedUser = userRepository.save(user);

        // convert User to UserDTO
        UserDTO savedUserDTO = UserMapper.mapToUserDTO(savedUser);

        return savedUserDTO;
    }

    @Override
    public UserDTO getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        UserDTO userDTO = UserMapper.mapToUserDTO(optionalUser.get());

        return userDTO;
    }

    @Override
    public List<UserDTO> getAllUser() {

        List<User> listUser = userRepository.findAll();

        List<UserDTO> listUserDTO = listUser.stream()
                .map(user -> UserMapper.mapToUserDTO(user))
                .collect(Collectors.toList());

        return listUserDTO;
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        User existingUser = userRepository.findById(user.getId()).get();

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        User updatedUser = userRepository.save(existingUser);

        UserDTO userDTO = UserMapper.mapToUserDTO(updatedUser);

        return userDTO;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
