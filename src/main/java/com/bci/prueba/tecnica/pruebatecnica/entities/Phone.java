package com.bci.prueba.tecnica.pruebatecnica.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Embeddable
@Data
@NoArgsConstructor
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @NotBlank
    private String number;

    @NotBlank
    @NotNull
    private String cityCode;

    @NotBlank
    @NotNull
    private String countryCode;

}
