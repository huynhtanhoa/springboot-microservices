package com.steven.springboot.repository;

import com.steven.springboot.dto.UserDTO;
import com.steven.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
