package com.bci.prueba.tecnica.pruebatecnica.controllers.dto;

import java.util.List;

import com.bci.prueba.tecnica.pruebatecnica.entities.Phone;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegisterResponseDto {
    private Long id;
    private String name;
    private String email;
    private List<Phone> phones;
    private String token;
    private boolean isActive;

}
