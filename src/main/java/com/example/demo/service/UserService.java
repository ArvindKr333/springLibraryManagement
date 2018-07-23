package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private Map<Long, User> userCache = new HashMap<>();
    private long counter = 1L;

    public UserService() {
        User user = new User(counter++, "Arvind Kumar", "ark123","arvind@jaza-soft.com", "arvind", "7657865978");

        userCache.put(user.getId(), user);
    }

    public Collection<User> findAll() {
        return userCache.values();
    }

    public User findOne(Long id) {
        return userCache.get(id);
    }

    public User saveUser(User user) {
        user.setId(counter++);
        userCache.put(user.getId(), user);
        return user;
    }

    public User update(User user) {
        userCache.put(user.getId(), user);
        return user;
    }

    public void delete(Long id) {
        userCache.remove(id);
    }
}
