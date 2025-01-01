package com.lti.user.userService.repositories;

import com.lti.user.userService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    //custom query parameters
}