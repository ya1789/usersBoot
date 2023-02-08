package com.example.usersboot.service;

import com.example.usersboot.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);

    User findUserById(long id);

    List listUsers();
}
