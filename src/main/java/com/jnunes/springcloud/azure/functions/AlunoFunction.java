package com.jnunes.springcloud.azure.functions;

import com.jnunes.springcloud.domain.Aluno;
import com.jnunes.springcloud.service.AlunoServiceImpl;
import com.jnunes.springcloud.suport.response.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class AlunoFunction {

    @Autowired
    private AlunoServiceImpl service;

    @Bean("alunoSave")
    public Function<Aluno, ResponseVO> save() {
        return aluno -> service.save(aluno);
    }

    @Bean("alunoGet")
    public Function<Long, ResponseVO> get() {
        return idAluno -> service.get(idAluno);
    }

    @Bean("alunoUpdate")
    public Function<Aluno, ResponseVO> update() {
        return aluno -> service.update(aluno);
    }

    @Bean("alunoDelete")
    public Function<Long, ResponseVO> delete() {
        return idAluno -> service.delete(idAluno);
    }

    @Bean("alunoList")
    public Function<Long, ResponseVO> list() {
        return idAluno -> service.list(idAluno);
    }

}
