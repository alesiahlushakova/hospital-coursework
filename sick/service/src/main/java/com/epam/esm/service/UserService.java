package com.epam.esm.service;

import com.epam.esm.dao.UserDao;
import com.epam.esm.entity.User;
import com.epam.esm.exception.EntityIsAlreadyExistException;
import com.epam.esm.exception.EntityIsNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User findById(Long id) {
        if (userDao.existsById(id)) {
            return userDao.findById(id);
        } else {
            throw new EntityIsNotExistException("user is not exist");
        }
    }

    public List<User> findAll(int page, int size) {
        return userDao.findAll(page, size);
    }

    @Transactional
    public void create(User user) {
        if (userDao.existsByUsername(user.getUsername())) {
            throw new EntityIsAlreadyExistException("user already exist");
        } else {
            userDao.create(user);
        }
    }

    @Transactional
    public void update(User user) {
        if (!userDao.existsById(user.getId())) {
            throw new EntityIsNotExistException("user is not exist");
        }
        if (userDao.isAnyUserExistWithUsername(user.getId(), user.getUsername())) {
            throw new EntityIsAlreadyExistException(
                    "user with this username:" + user.getUsername() + " already exist");
        }
        userDao.update(user);
    }

    @Transactional
    public void delete(Long id) {
        if (userDao.existsById(id)) {
            userDao.delete(id);
        } else {
            throw new EntityIsNotExistException("user is not exist");
        }
    }

    public Long findCountUsers() {
        return userDao.findCountUsers();
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public boolean isExistByUsername(String username) {
        return userDao.existsByUsername(username);
    }
}
