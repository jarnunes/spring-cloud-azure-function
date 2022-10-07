package com.jnunes.springcloud.service;

import com.jnunes.springcloud.domain.Aluno;

import java.util.List;


public interface AlunoService {

    List<Aluno> obterAlunosPorNome(String nome);

    List<Aluno> obterAlunosPorCurso(String tituloCurso);

    List<Aluno> obterAlunosPorIntevalosIdReferencia(Long idReferencia, Integer numeroRegistros);
}
