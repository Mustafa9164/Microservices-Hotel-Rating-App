package com.lti.user.userService.services.impl;

import com.lti.user.userService.entities.User;
import com.lti.user.userService.exception.ResourceNotFoundException;
import com.lti.user.userService.repositories.UserRepository;
import com.lti.user.userService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getuser(String userId) {
        return userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user with given id does not exist"+userId));
    }

    @Override
    public void deleteUser(String userId) {
        Optional<User> optional = userRepository.findById(userId);
        if(optional.isPresent()){
            userRepository.deleteById(userId);
        }
    }

    @Override
    public User updateUser(String userId, User newUser) {
        Optional<User> optional = userRepository.findById(userId);
        if(optional.isPresent()) {
            newUser.setUserId(userId);
            return userRepository.save(newUser);
        }else {
            throw new ResourceNotFoundException("User " + userId + "user with given id does not exist");
        }
    }
}
