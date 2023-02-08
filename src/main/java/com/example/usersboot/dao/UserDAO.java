package com.example.usersboot.dao;


import com.example.usersboot.model.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);

    User findUserById(long id);

    List listUsers();
}
