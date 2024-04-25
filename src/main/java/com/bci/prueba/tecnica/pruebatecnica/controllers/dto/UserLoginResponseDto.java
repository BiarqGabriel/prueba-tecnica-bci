package com.bci.prueba.tecnica.pruebatecnica.controllers.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginResponseDto {
    private String token;
}
