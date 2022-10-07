package com.jnunes.springcloud.service;

import com.jnunes.springcloud.domain.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoServiceImpl extends BaseServiceImpl<Aluno> implements AlunoService {

    @Autowired
    private AlunoRepository repository;

    @Override
    public List<Aluno> obterAlunosPorNome(String nome) {
        return repository.obterAlunosPorNome(nome);
    }

    @Override
    public List<Aluno> obterAlunosPorCurso(String tituloCurso) {
        return repository.obterAlunosPorCurso(tituloCurso);
    }

    @Override
    public List<Aluno> obterAlunosPorIntevalosIdReferencia(Long idReferencia, Integer numeroRegistros) {
        return repository.obterAlunosPorInicioFimReferenciaId(idReferencia, numeroRegistros.longValue());
    }

}
