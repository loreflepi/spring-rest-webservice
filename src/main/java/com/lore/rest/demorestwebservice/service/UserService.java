package com.lore.rest.demorestwebservice.service;

import com.lore.rest.demorestwebservice.dto.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private static List<User> users = new ArrayList<>(Arrays.asList(
            new User("1", "Morchi", new Date()),
            new User("2", "Lore", new Date()),
            new User("3", "Mama", new Date())));

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId() == null){
            user.setId(UUID.randomUUID().toString());
        }
        users.add(user);
        return user;
    }

    public Optional<User> findById(String id){
        return users.stream().filter(value -> value.getId().equalsIgnoreCase(id)).findFirst();
    }
}
