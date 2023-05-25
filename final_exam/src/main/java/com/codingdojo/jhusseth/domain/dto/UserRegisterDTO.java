package com.codingdojo.jhusseth.domain.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserRegisterDTO {

    private Long id;

    @NotEmpty(message = "¡Se requiere Username!")
    @Size(min = 3, max = 30, message = "Username debe tener entre 3 y 30 caracteres")
    private String username;

    @NotEmpty(message = "¡Se requiere Email!")
    @Email(message = "¡Ingrese un Email válido!")
    private String email;

    @NotEmpty(message = "¡Se requiere contraseña!")
    @Size(min = 8, max = 128, message = "La contraseña debe tener entre 8 y 128 caracteres")
    private String password;

    @NotEmpty(message = "Confirm Password is required!")
    @Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters")
    private String confirmPassword;

}
