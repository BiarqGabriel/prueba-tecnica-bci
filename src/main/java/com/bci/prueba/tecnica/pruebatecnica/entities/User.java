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
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "users")
@Data
@NoArgsConstructor


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @NotNull
    private String name;

    @Column(unique = true)
    @Email
    private String email;

    @Pattern( regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$" , message = "La contraseña debe tener al menos una letra mayúscula, una letra minúscula, un número y un tamaño de 8 a 20 caracteres")
    private String password;

    @ElementCollection
    private List<Phone> phones;

    private Date created;

    private Date modified;

    private Date lastLogin;

    @Column(columnDefinition = "boolean default true")
    private boolean isActive;
}
