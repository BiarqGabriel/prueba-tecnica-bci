package com.bci.prueba.tecnica.pruebatecnica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bci.prueba.tecnica.pruebatecnica.controllers.dto.UserDTO;
import com.bci.prueba.tecnica.pruebatecnica.entities.User;
import com.bci.prueba.tecnica.pruebatecnica.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    

    @Autowired
    private  UserService userService;

    @GetMapping
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        User user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody UserDTO user) {
        User userSaved = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
    }
}
