package com.steven.springboot.mapper;

import com.steven.springboot.dto.UserDTO;
import com.steven.springboot.entity.User;

public class UserMapper {

    public static UserDTO mapToUserDTO(User user){
        // convert User to UserDTO
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );

        return userDTO;
    }

    public static User mapToUser(UserDTO userDTO){
        // convert User to UserDTO
        User user = new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail()
        );

        return user;
    }


}
