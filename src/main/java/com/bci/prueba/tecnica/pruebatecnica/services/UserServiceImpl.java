package com.bci.prueba.tecnica.pruebatecnica.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bci.prueba.tecnica.pruebatecnica.controllers.dto.UserDTO;
import com.bci.prueba.tecnica.pruebatecnica.entities.User;
import com.bci.prueba.tecnica.pruebatecnica.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private  UserRepository userRepository;


    @Value("${jwt.secret}")
    private String secretKey;

    @Value ("${jwt.expiration}")
    private Integer expiration;

    private String generateToken(User user){
        long now = System.currentTimeMillis();
        Date nowDate = new Date(now);
        Date expirationTime = new Date(now + expiration); // 1 hora
        return JWT.create()
                .withIssuedAt(nowDate)
                .withExpiresAt(expirationTime)
                .withClaim("email", user.getEmail())
                .sign(Algorithm.HMAC256(secretKey));
    }

    @Override
    public User saveUser(UserDTO userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("User is required");
        }
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setPhones(userDTO.getPhones());
        user.setPassword(userDTO.getPassword());
        user.setCreated(new Date());
        user.setToken(generateToken(user));
        user.setModified(new Date());
        user.setLastLogin(new Date());
        return userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email is required");
        }
        User user = userRepository.findByEmail(email);
        if(user == null) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
        return user;
    }

    

}
