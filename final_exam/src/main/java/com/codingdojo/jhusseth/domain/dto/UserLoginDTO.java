package com.codingdojo.jhusseth.domain.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserLoginDTO {

    @NotEmpty(message = "¡Se requiere Email!")
    @Email(message = "¡Ingrese un Email válido!")
    private String email;

    @NotEmpty(message = "¡Se requiere contraseña!")
    private String password;

}
