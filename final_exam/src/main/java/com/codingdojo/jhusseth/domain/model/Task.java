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
@Table(name = "TB_TASK")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotEmpty(message = "¡Se requiere el nombre de la tarea!")
    @Column(name = "NAME", length = 120)
    private String name;

    @ManyToOne
    @JoinColumn(name = "TB_USER_ASSIGNEE_TASK_ID")
    private User assigneeUser;

    @ManyToOne
    @JoinColumn(name = "TB_USER_CREATED_TASK_ID")
    private User creatorUser;

    @ManyToOne
    @JoinColumn(name = "TB_PRIORITY_ID")
    private Priority priority;

    @Column(name = "COMPLETE")
    private boolean complete;

    @PrePersist
    protected void onCreate() {
        this.complete = false;
    }

}
