package com.jnunes.springcloud.service;

import com.jnunes.springcloud.domain.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CursoServiceImpl extends BaseServiceImpl<Curso> implements CursoService {

    @Autowired
    private CursoRepository repository;


    @Override
    public List<Curso> obterCursosPorIntervaloId(Long idReferencia, Integer numeroRegistros) {
        return repository.obterCursosPorInicioFimReferenciaId(idReferencia, numeroRegistros.longValue());
    }

    @Override
    public List<Curso> obterCursosPorTitulo(String titulo){
        return  repository.obterCursosPorTitulo(titulo);
    }

    @Override
    public List<Curso> obterCursosPorDataInicioReferencia(LocalDate inicioReferencia, LocalDate fimReferencia){
        return repository.obterCursosPorDataInicioReferencia(inicioReferencia, fimReferencia);
    }
}
