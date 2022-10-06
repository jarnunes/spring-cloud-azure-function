package com.jnunes.springcloud.service;

import com.jnunes.springcloud.domain.Curso;
import com.sun.istack.NotNull;

import java.time.LocalDate;
import java.util.List;


public interface CursoService  {

    List<Curso> obterCursosPorIntervaloId(@NotNull Long idReferencia, @NotNull Integer numeroRegistros);

    List<Curso> obterCursosPorTitulo(String titulo);

    List<Curso> obterCursosPorDataInicioReferencia(@NotNull LocalDate inicioReferencia, @NotNull LocalDate fimReferencia);
}
