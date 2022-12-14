package com.jnunes.springcloud.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(initialValue = 1, name = "spcloud", sequenceName = "sequence_curso")
@Table(indexes = {@Index(columnList = "titulo, data_inicio", unique = true, name = "UK_titulo_datainicio")})
public class Curso extends EntityS{

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(nullable = false)
    private Integer cargaHoraria;

    @Column(name = "data_inicio")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;
}
