package com.bci.prueba.tecnica.pruebatecnica.repositories;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bci.prueba.tecnica.pruebatecnica.controllers.dto.UserDTO;
import com.bci.prueba.tecnica.pruebatecnica.dto.UserDtoResponse;
import com.bci.prueba.tecnica.pruebatecnica.entities.User;

@Repository
public interface UserRepository  extends CrudRepository<User, Long>{
        
        public User save(UserDTO userDTO);

        public User findByEmail(String email);
}
