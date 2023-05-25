package com.codingdojo.jhusseth.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDTO {

    private Long id;

    private String username;

    private String email;

}
