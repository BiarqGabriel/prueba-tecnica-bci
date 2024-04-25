package com.bci.prueba.tecnica.pruebatecnica;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bci.prueba.tecnica.pruebatecnica.controllers.dto.UserDTO;
import com.bci.prueba.tecnica.pruebatecnica.controllers.dto.UserLoginRequestDto;
import com.bci.prueba.tecnica.pruebatecnica.controllers.dto.UserLoginResponseDto;
import com.bci.prueba.tecnica.pruebatecnica.controllers.dto.UserRegisterResponseDto;
import com.bci.prueba.tecnica.pruebatecnica.entities.Phone;
import com.bci.prueba.tecnica.pruebatecnica.entities.User;
import com.bci.prueba.tecnica.pruebatecnica.jwt.JwtService;
import com.bci.prueba.tecnica.pruebatecnica.repositories.UserRepository;
import com.bci.prueba.tecnica.pruebatecnica.services.UserService;
import com.bci.prueba.tecnica.pruebatecnica.services.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private UserServiceImpl userService;

    @Value("${password.pattern}")
    private String pswdPattern;

    @Value("${password.message}")
    private String pswdMessage;

    private User user;

    @BeforeEach
    void setUp() {  
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void saveUser_WithValidUserDTO_ShouldReturnUserRegisterResponseDto() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Gabriel Martinez");
        userDTO.setEmail("Gabriel@example.com");
        userDTO.setPassword("Password123");

        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        user.setCreated(new Date());
        user.setModified(new Date());
        user.setLastLogin(new Date());
        user.setActive(true);

        when(userRepository.save(any(User.class))).thenReturn(user);

        // Act
        UserRegisterResponseDto responseDto = userService.saveUser(userDTO);

        // Assert
        assertNotNull(responseDto);
        assertEquals(user.getId(), responseDto.getId());
        assertEquals(user.getName(), responseDto.getName());
        assertEquals(user.getEmail(), responseDto.getEmail());
        assertEquals(user.getPhones(), responseDto.getPhones());
        assertTrue(responseDto.isActive());
    }

    @Test
    void getUserByEmail_WithNonExistingEmail_ThrowsException() {
        when(userRepository.findByEmail(any(String.class))).thenReturn(null);

        assertThrows(NullPointerException.class, () -> userService.getUserByEmail("noexiste@example.com"));
    }


}
