package com.jnunes.springcloud.service;

import com.jnunes.springcloud.domain.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoServiceImpl extends BaseServiceImpl<Aluno> {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private CursoRepository cursoRepository;


}
