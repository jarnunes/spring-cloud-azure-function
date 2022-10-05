package com.jnunes.springcloud.azure.functions;

import com.jnunes.springcloud.domain.Curso;
import com.jnunes.springcloud.service.CursoServiceImpl;
import com.jnunes.springcloud.suport.response.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class CursoFunction {

    @Autowired
    private CursoServiceImpl service;

    @Bean("cursoSave")
    public Function<Curso, ResponseVO> save() {
        return curso -> service.save(curso);
    }

    @Bean("cursoGet")
    public Function<Long, ResponseVO> get() {
        return idCurso -> service.get(idCurso);
    }

    @Bean("cursoUpdate")
    public Function<Curso, ResponseVO> update() {
        return curso -> service.update(curso);
    }

    @Bean("cursoDelete")
    public Function<Long, ResponseVO> delete() {
        return idCurso -> service.delete(idCurso);
    }

    @Bean("cursoList")
    public Function<Long, ResponseVO> list() {
        return idCurso -> service.list(idCurso);
    }

}
