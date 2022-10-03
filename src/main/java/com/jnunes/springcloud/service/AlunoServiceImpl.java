package com.jnunes.springcloud.service;

import com.jnunes.springcloud.domain.Aluno;
import com.jnunes.springcloud.suport.response.Response;
import com.jnunes.springcloud.suport.response.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository repository;

    @Override
    public ResponseVO save(Aluno aluno) {
        repository.save(aluno);
        return Response.success(aluno);
    }

    @Override
    public ResponseVO get(Long id) {
        return repository.findById(id).map(Response::success).orElseThrow(RuntimeException::new);
    }

    @Override
    public ResponseVO delete(Long id) {
        repository.deleteById(id);
        return Response.success(true);
    }

    @Override
    public ResponseVO update(Aluno aluno) {
        return Optional.of(repository.save(aluno)).map(Response::success).orElse(Response.error().getDetalhe());
    }

    @Override
    public ResponseVO list(Long id) {
        return Optional.ofNullable(id)
                .map(idAluno -> repository.findById(idAluno)).map(Response::success)
                .orElse(Response.success(repository.findAll()));
    }

}
