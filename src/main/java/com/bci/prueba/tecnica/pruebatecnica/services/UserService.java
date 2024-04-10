package com.bci.prueba.tecnica.pruebatecnica.services;

import com.bci.prueba.tecnica.pruebatecnica.controllers.dto.UserDTO;
import com.bci.prueba.tecnica.pruebatecnica.entities.User;

public interface UserService {

    public User saveUser(UserDTO userDTO);

    public User getUserByEmail(String email);

}
