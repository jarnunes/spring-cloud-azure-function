package com.jnunes.springcloud.azure.functions;

import com.jnunes.springcloud.azure.functions.consts.FunctionConsts;
import com.jnunes.springcloud.domain.Aluno;
import com.jnunes.springcloud.domain.Curso;
import com.jnunes.springcloud.service.AlunoServiceImpl;
import com.jnunes.springcloud.suport.response.ErrorResponse;
import com.jnunes.springcloud.suport.response.ResponseVO;
import com.jnunes.springcloud.suport.response.Success;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Configuration
public class AlunoFunction extends BaseFunction {

    @Autowired
    private AlunoServiceImpl service;

    @Bean("alunoSave")
    public Function<Aluno, ResponseVO> save() {
        return aluno -> service.save(aluno);
    }

    @Bean("alunoGet")
    public Function<Map<String, String>, ResponseVO> get() {
        return this::getAluno;
    }

    private ResponseVO getAluno(Map<String, String> map) {
        Long idReferencia = FunctionConsts.of(map).getIdReferencia();
        if (Objects.nonNull(idReferencia)) {
            return service.get(idReferencia).map(aluno -> Success.of(aluno).statusOk())
                .orElse(ErrorResponse.resourceIdNotFound(idReferencia).build());
        }

        String nome = FunctionConsts.of(map).getNome();
        if (Objects.nonNull(nome)) {
            return service.obterAlunosPorNome(nome).stream().findFirst().map(aluno -> Success.of(aluno).statusOk())
                .orElse(ErrorResponse.resourceIdentifierNotFound(nome).build());
        }
        return responseToInvalidParameter();
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
    public Function<Map<String, String>, ResponseVO> list() {
        return this::montarLista;
    }

    private ResponseVO montarLista(Map<String, String> map) {
        String curso = FunctionConsts.of(map).getCurso();
        if (Objects.nonNull(curso)) {
            return listToResponse(service.obterAlunosPorCurso(curso));
        }

        Integer numeroRegistros = FunctionConsts.of(map).getNumeroRegistros();
        Long idReferencia = FunctionConsts.of(map).getIdReferencia();
        if(ObjectUtils.allNotNull(idReferencia, numeroRegistros)){
            return listToResponse(service.obterAlunosPorIntevalosIdReferencia(idReferencia, numeroRegistros));
        }

        String nome = FunctionConsts.of(map).getNome();
        if (Objects.nonNull(nome)) {
            return listToResponse(service.obterAlunosPorNome(nome));
        }
        return responseToInvalidParameter();
    }

}
