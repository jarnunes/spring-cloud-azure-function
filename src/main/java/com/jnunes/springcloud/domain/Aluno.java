package com.jnunes.springcloud.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Aluno extends EntityS {

    @Column(nullable = false)
    private String name;

    private String email;

    private String telefone;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "alunos_cursos", joinColumns = @JoinColumn(name = "aluno_fk"),
        inverseJoinColumns = @JoinColumn(name = "curso_fk"))
    private Set<Curso> cursos = new HashSet<>();

}
