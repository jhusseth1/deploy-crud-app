package com.codingdojo.jhusseth.domain.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TaskDTO {

    private Long id;

    @NotNull(message = "El campo nombre no debe ser nulo")
    @NotBlank(message = "El campo nombre no debe estar vacio")
    @NotEmpty(message = "El campo nombre no debe estar vacio")
    private String name;

    private String assigneeUsername;

    private String creatorUsername;

    private String priorityCode;

    private Long assigneeUserId;

    private Long creatorUserId;

    private Long priorityId;

    private boolean complete;

}
