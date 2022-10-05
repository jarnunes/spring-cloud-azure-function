package com.jnunes.springcloud.service;

import com.jnunes.springcloud.domain.Aluno;
import com.jnunes.springcloud.domain.Curso;
import com.jnunes.springcloud.suport.response.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AlunoServiceImpl extends BaseServiceImpl<Aluno> {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private CursoRepository cursoRepository;


}
