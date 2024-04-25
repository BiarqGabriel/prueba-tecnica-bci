package com.bci.prueba.tecnica.pruebatecnica.services;

import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bci.prueba.tecnica.pruebatecnica.controllers.dto.UserDTO;
import com.bci.prueba.tecnica.pruebatecnica.controllers.dto.UserLoginRequestDto;
import com.bci.prueba.tecnica.pruebatecnica.controllers.dto.UserLoginResponseDto;
import com.bci.prueba.tecnica.pruebatecnica.controllers.dto.UserRegisterResponseDto;
import com.bci.prueba.tecnica.pruebatecnica.entities.User;
import com.bci.prueba.tecnica.pruebatecnica.jwt.JwtService;
import com.bci.prueba.tecnica.pruebatecnica.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private final JwtService jwtService;



    @Override
    public UserRegisterResponseDto saveUser(UserDTO userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("User body es requerido");
        }
        
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhones(userDTO.getPhones());
        user.setCreated(new Date());
        user.setModified(new Date());
        user.setLastLogin(new Date());
        user.setActive(true);
        userRepository.save(user);

        return UserRegisterResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phones(user.getPhones())
                .isActive(user.isActive())
                .token(jwtService.getToken(user))
                .build();
    }

    @Override
    public User getUserByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Correo es Requerido");
        }
        User user = userRepository.findByEmail(email).orElse(null);
        if(user == null ) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
        return user;
    }

    @Override
    public UserLoginResponseDto doLogin(UserLoginRequestDto user) {
        if (user == null) {
            throw new IllegalArgumentException("Usuario es Requrido");
        }
        User userEntity = userRepository.findByEmail(user.getEmail()).orElse(null);
        if(userEntity == null ) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
        if(!userEntity.getPassword().equals(user.getPassword())) {
            throw new IllegalArgumentException("Contraseña incorrecta");
        }
        userEntity.setLastLogin(new Date());
        userRepository.save(userEntity);
        return UserLoginResponseDto.builder()
                .token(jwtService.getToken(userEntity))
                .build();
    }

    

}
