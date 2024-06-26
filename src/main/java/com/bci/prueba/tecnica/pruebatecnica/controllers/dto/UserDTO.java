package com.bci.prueba.tecnica.pruebatecnica.controllers.dto;

import java.util.List;

import com.bci.prueba.tecnica.pruebatecnica.entities.Phone;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserDTO {


    private String name;


    private String email;

  
    private String password;


    private List<Phone> phones;
}
