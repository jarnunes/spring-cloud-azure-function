package com.jnunes.springcloud.service;

import com.jnunes.springcloud.domain.Aluno;
import com.jnunes.springcloud.domain.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl extends BaseServiceImpl<Curso> {

    @Autowired
    private AlunoRepository repository;

}
