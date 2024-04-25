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
import com.bci.prueba.tecnica.pruebatecnica.controllers.dto.UserLoginRequestDto;
import com.bci.prueba.tecnica.pruebatecnica.controllers.dto.UserLoginResponseDto;
import com.bci.prueba.tecnica.pruebatecnica.controllers.dto.UserRegisterResponseDto;
import com.bci.prueba.tecnica.pruebatecnica.entities.User;
import com.bci.prueba.tecnica.pruebatecnica.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    

    @Autowired
    private  UserService userService;

    //Endpoint to search user by email using Springboot Security Token JWT
    @GetMapping
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        User user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }


    //EndPoint to Register new User
    @PostMapping()
    public ResponseEntity<UserRegisterResponseDto> saveUser(@RequestBody UserDTO user) {
        UserRegisterResponseDto userSaved = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
    }


    //Endpoint to simulate login request using Springboot Security Token JWT and return a token
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDto> doLogin (@RequestBody UserLoginRequestDto user)
    {
        UserLoginResponseDto userLogin = userService.doLogin(user);
        return ResponseEntity.ok(userLogin);
    }

   

}
