package com.bci.prueba.tecnica.pruebatecnica.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bci.prueba.tecnica.pruebatecnica.controllers.dto.UserDTO;
import com.bci.prueba.tecnica.pruebatecnica.entities.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
        
        public User save(UserDTO userDTO);

        public Optional<User> findByEmail(String email);
}
