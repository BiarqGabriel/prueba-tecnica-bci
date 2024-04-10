package com.bci.prueba.tecnica.pruebatecnica;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bci.prueba.tecnica.pruebatecnica.controllers.dto.UserDTO;
import com.bci.prueba.tecnica.pruebatecnica.entities.Phone;
import com.bci.prueba.tecnica.pruebatecnica.entities.User;
import com.bci.prueba.tecnica.pruebatecnica.repositories.UserRepository;
import com.bci.prueba.tecnica.pruebatecnica.services.UserService;
import com.bci.prueba.tecnica.pruebatecnica.services.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceImplTest {
    
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private UserDTO userDTO;
    private User user;


    @BeforeEach
    void init() {
        userDTO = new UserDTO();
        userDTO.setName("Gabriel");
        userDTO.setEmail("Gabriel@Tst.com");
        userDTO.setPassword("Test@1234");
    
        user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setCreated(new Date());
        user.setToken("dummyTokenValue"); 
        userService.setPswdPattern("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");
        userService.setSecretKey("dummyTokenValue");
        userService.setExpiration(3600000);
    }
    
    @Test
    void saveUser_WithValidUser_ShouldReturnUser() {
        when(userRepository.save(any(User.class))).thenReturn(user);
    
        User result = userService.saveUser(userDTO);
    
        assertNotNull(result);
        assertNotNull(result.getToken());
        assertEquals(userDTO.getEmail(), result.getEmail());
        assertEquals(userDTO.getName(), result.getName());
    }

    @Test
    void getUserByEmail_WithExistingEmail_ReturnsUser() {
        when(userRepository.findByEmail(any(String.class))).thenReturn(Optional.of(user));

        User result = userService.getUserByEmail("Gabriel@Tst.com");

        assertEquals("Gabriel@Tst.com", result.getEmail());
    }

    @Test
    void getUserByEmail_WithNonExistingEmail_ThrowsException() {
        when(userRepository.findByEmail(any(String.class))).thenReturn(null);

        assertThrows(NullPointerException.class, () -> userService.getUserByEmail("noexiste@example.com"));
    }
}
