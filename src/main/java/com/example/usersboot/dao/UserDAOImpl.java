package com.example.usersboot.dao;


import com.example.usersboot.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private static final String GET_ALL_USERS = "from User";
    public static final String DELETE_USER_BY_ID = "delete from User u where u.id=:id";
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        try {
            entityManager.createQuery(DELETE_USER_BY_ID).setParameter("id", id).executeUpdate();

        } catch (Exception e) {
            System.out.println("Unable to find user by this id");
        }
        entityManager.flush();
    }


//    @Transactional
//    @Override
//    public void deleteUser(Long id) {
//        try {
//            entityManager.remove(findUserById(id));
//        } catch (Exception e) {
//            System.out.println("Unable to find user by this id");
//        }
//        entityManager.flush();
//
//    }

    @Transactional
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        entityManager.flush();

    }

    @Override
    public User findUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List listUsers() {
        return entityManager.createQuery(GET_ALL_USERS).getResultList();
    }
}
