package com.bci.prueba.tecnica.pruebatecnica.controllers.dto;

import lombok.Data;

@Data
public class UserLoginRequestDto {
    private String email;
    private String password;
}
