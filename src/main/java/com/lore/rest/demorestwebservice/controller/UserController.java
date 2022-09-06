package com.lore.rest.demorestwebservice.controller;

import com.lore.rest.demorestwebservice.dto.User;
import com.lore.rest.demorestwebservice.exception.UserNotFoundException;
import com.lore.rest.demorestwebservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User findById(@PathVariable String id){
        Optional<User> optionalUser = userService.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        throw new UserNotFoundException("user not found with id " + id);
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Void> createUser(@RequestBody User user){
        User savedUser = userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
