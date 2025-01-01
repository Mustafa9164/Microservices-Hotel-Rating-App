package com.lti.user.userService.services;

import com.lti.user.userService.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User getuser(String userId);

    void deleteUser(String userId);

    User updateUser(String userId, User newUser);
}
