package com.bci.prueba.tecnica.pruebatecnica.entities;

import java.util.Date;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;



@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @NotNull
    private String name;

    @Column(unique = true)
    @Email(message = "Debe ser un correo válido")
    private String email;

    private String password;

    @ElementCollection
    private List<Phone> phones;

    private Date created;

    private Date modified;

    private Date lastLogin;

    private String token;

    @Column(columnDefinition = "boolean default true")
    private boolean isActive;
}
