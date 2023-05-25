package com.codingdojo.jhusseth.domain.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PriorityDTO {

    private Long id;

    @NotEmpty(message = "¡Se requiere el nombre!")
    private String code;

    @NotEmpty(message = "¡Se requiere el valor!")
    private int value;

}
