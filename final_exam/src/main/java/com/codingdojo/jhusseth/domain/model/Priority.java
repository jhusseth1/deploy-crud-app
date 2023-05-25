package com.codingdojo.jhusseth.domain.model;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_PRIORITY")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Priority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotEmpty(message = "¡Se requiere el codigo!")
    @Column(name = "CODE")
    private String code;

    @NotEmpty(message = "¡Se requiere el valor!")
    @Column(name = "VALUE")
    private int value;

}
