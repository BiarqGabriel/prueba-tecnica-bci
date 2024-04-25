package com.bci.prueba.tecnica.pruebatecnica.services;

import com.bci.prueba.tecnica.pruebatecnica.controllers.dto.UserDTO;
import com.bci.prueba.tecnica.pruebatecnica.controllers.dto.UserLoginRequestDto;
import com.bci.prueba.tecnica.pruebatecnica.controllers.dto.UserLoginResponseDto;
import com.bci.prueba.tecnica.pruebatecnica.controllers.dto.UserRegisterResponseDto;
import com.bci.prueba.tecnica.pruebatecnica.entities.User;

public interface UserService {

    public UserRegisterResponseDto saveUser(UserDTO userDTO);

    public User getUserByEmail(String email);

    public UserLoginResponseDto doLogin(UserLoginRequestDto user);

}
