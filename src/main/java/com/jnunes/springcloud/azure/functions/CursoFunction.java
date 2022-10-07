package com.jnunes.springcloud.azure.functions;

import com.jnunes.springcloud.azure.functions.consts.FunctionConsts;
import com.jnunes.springcloud.domain.Curso;
import com.jnunes.springcloud.service.CursoServiceImpl;
import com.jnunes.springcloud.suport.response.ErrorResponse;
import com.jnunes.springcloud.suport.response.ResponseVO;
import com.jnunes.springcloud.suport.response.Success;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Configuration
public class CursoFunction extends BaseFunction {

    Logger logger = LoggerFactory.getLogger(CursoFunction.class);

    @Autowired
    private CursoServiceImpl service;

    @Bean("cursoSave")
    public Function<Curso, ResponseVO> save() {
        return curso -> service.save(curso);
    }

    @Bean("cursoGet")
    public Function<Map<String, String>, ResponseVO> get() {
        return this::getCurso;
    }

    private ResponseVO getCurso(Map<String, String> map) {
        Long idReferencia = FunctionConsts.of(map).getIdReferencia();
        if (Objects.nonNull(idReferencia)) {
            return service.get(idReferencia).map(curso -> Success.of(curso).statusOk())
                    .orElse(ErrorResponse.resourceIdNotFound(idReferencia).build());
        }

        String titulo = FunctionConsts.of(map).getTitulo();
        if (Objects.nonNull(titulo)) {
            return service.obterCursosPorTitulo(titulo).stream().findFirst().map(curso -> Success.of(curso).statusOk())
                    .orElse(ErrorResponse.resourceIdentifierNotFound(titulo).build());
        }
        return responseToInvalidParameter();
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
    public Function<Map<String, String>, ResponseVO> list() {
        return this::montarLista;
    }

    private ResponseVO montarLista(Map<String, String> map) {

        Long idReferencia = FunctionConsts.of(map).getIdReferencia();
        Integer numeroRegistros = FunctionConsts.of(map).getNumeroRegistros();
        if (ObjectUtils.allNotNull(idReferencia, numeroRegistros)) {
            return obterCursosPorId(idReferencia, numeroRegistros);
        }

        LocalDate dataInicioReferencia = FunctionConsts.of(map).getDataInicioReferencia();
        LocalDate dataFimReferencia = FunctionConsts.of(map).getDataFimReferencia();
        if (ObjectUtils.allNotNull(dataInicioReferencia, dataFimReferencia)) {
            return obterCursosPorDataReferencia(dataInicioReferencia, dataFimReferencia);
        }

        String titulo = FunctionConsts.of(map).getTitulo();
        if (StringUtils.isNotEmpty(titulo)) {
            return obterCursosPorTitulo(titulo);
        }
        return responseToInvalidParameter();
    }

    private ResponseVO obterCursosPorId(Long idReferencia, Integer numeroRegistros) {
        List<Curso> cursos = service.obterCursosPorIntervaloId(idReferencia, numeroRegistros);
        return listToResponse(cursos);
    }

    private ResponseVO obterCursosPorDataReferencia(LocalDate inicio, LocalDate fim) {
        List<Curso> cursos = service.obterCursosPorDataInicioReferencia(inicio, fim);
        return listToResponse(cursos);
    }

    private ResponseVO obterCursosPorTitulo(String titulo) {
        List<Curso> cursos = service.obterCursosPorTitulo(titulo);
        return listToResponse(cursos);
    }
}
