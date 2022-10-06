package com.jnunes.springcloud.azure.functions;

import com.jnunes.springcloud.azure.functions.consts.FunctionConsts;
import com.jnunes.springcloud.domain.Aluno;
import com.jnunes.springcloud.service.AlunoServiceImpl;
import com.jnunes.springcloud.suport.response.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
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
    public Function<Map<String, String>, ResponseVO> get() {
        return map -> service.get(FunctionConsts.of(map).getIdReferencia());
    }

    @Bean("alunoUpdate")
    public Function<Aluno, ResponseVO> update() {
        return aluno -> service.update(aluno);
    }

    @Bean("alunoDelete")
    public Function<Long, ResponseVO> delete() {
        return idAluno -> service.delete(idAluno);
    }

//    @Bean("alunoList")
//    public Function<Long, ResponseVO> list() {
//        return idAluno -> service.list(idAluno);
//    }

}
