package com.bci.prueba.tecnica.pruebatecnica.dto;

import java.sql.Date;
import java.util.List;

import com.bci.prueba.tecnica.pruebatecnica.entities.Phone;

import lombok.Data;

@Data
public class UserDtoResponse {
    private Long id;
    private String name;
    private String email;
    private String password;
    private List<Phone> phones;
    private Date created;
    private Date modified;
    private Date last_login;
    private String token;
    private boolean isActive;
}
