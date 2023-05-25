package com.codingdojo.jhusseth.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_USER")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotEmpty(message = "¡Se requiere Username!")
    @Size(min = 3, max = 30, message = "Username debe tener entre 3 y 30 caracteres")
    @Column(name = "USERNAME", length = 30)
    private String username;

    @NotEmpty(message = "¡Se requiere Email!")
    @Email(message = "¡Ingrese un Email válido!")
    @Column(name = "EMAIL")
    private String email;

    @NotEmpty(message = "¡Se requiere contraseña!")
    @Size(min = 8, message = "La contraseña debe tener minimo 8 caracteres")
    @Column(name = "PASSWORD")
    private String password;

    @Transient
    @NotEmpty(message = "¡Se requiere la confirmacion de la contraseña!")
    @Size(min = 8, message = "La contraseña debe tener minimo 8 caracteres")
    @Column(name = "CONFIRM_PASSWORD")
    private String confirmPassword;

    @OneToMany(mappedBy = "creatorUser")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnore
    private List<Task> createdTask = new ArrayList<>();

    @OneToMany(mappedBy = "assigneeUser")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnore
    private List<Task> assigneeTask = new ArrayList<>();
}
