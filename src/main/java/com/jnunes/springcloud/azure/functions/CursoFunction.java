package com.jnunes.springcloud.azure.functions;

import com.google.gson.Gson;
import com.jnunes.springcloud.domain.Curso;
import com.jnunes.springcloud.service.CursoServiceImpl;
import com.jnunes.springcloud.suport.DateUtils;
import com.jnunes.springcloud.suport.Utils;
import com.jnunes.springcloud.suport.response.ResponseVO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.json.GsonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static com.jnunes.springcloud.suport.response.StatusCode.*;
import static com.jnunes.springcloud.azure.functions.ConstsKeyMap.*;

@Configuration
public class CursoFunction {

    Logger logger = LoggerFactory.getLogger(CursoFunction.class);

    @Autowired
    private CursoServiceImpl service;

    @Bean("cursoSave")
    public Function<Object, ResponseVO> save() {
        return this::internalSave;
    }

    private ResponseVO internalSave(Object cursoObject){
        Gson gson = new Gson();
        Curso curso = gson.fromJson(String.valueOf(cursoObject), Curso.class);
        return service.save(curso);
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
    public Function<Map<String, String>, ResponseVO> list() {
        return this::montarLista;
    }

    private ResponseVO montarLista(Map<String, String> map) {

        Long idReferencia = Utils.toLongOrNull(map.get(ID_REFERENCIA));
        Integer numeroRegistros = Utils.toIntOrNull(map.get(NUMERO_REGISTROS));
        if (ObjectUtils.allNotNull(idReferencia, numeroRegistros)) {
            return obterCursosPorId(idReferencia, numeroRegistros);
        }

        LocalDate dataInicioReferencia = DateUtils.toLocalDate(map.get(DATA_INICIO_REFERENCIA));
        LocalDate dataFimReferencia = DateUtils.toLocalDate(map.get(DATA_FIM_REFERENCIA));
        if (ObjectUtils.allNotNull(dataInicioReferencia, dataFimReferencia)) {
            return obterCursosPorDataReferencia(dataInicioReferencia, dataFimReferencia);
        }

        String titulo = StringUtils.trimToNull(map.get(TITULO));
        if (StringUtils.isNotEmpty(titulo)) {
            return obterCursosPorTitulo(titulo);
        }

        ResponseVO response = new ResponseVO();
        response.setMessage(Utils.getMessage("response.cursos.lista.sem.parametros"));
        response.setStatusCode(INVALID_PARAMETER);
        return response;
    }

    private ResponseVO obterCursosPorId(Long idReferencia, Integer numeroRegistros) {
        List<Curso> cursos = service.obterCursosPorIntervaloId(idReferencia, numeroRegistros);
        return listCursosToResponse(cursos);
    }

    private ResponseVO obterCursosPorDataReferencia(LocalDate inicio, LocalDate fim) {
        List<Curso> cursos = service.obterCursosPorDataInicioReferencia(inicio, fim);
        return listCursosToResponse(cursos);
    }

    private ResponseVO obterCursosPorTitulo(String titulo) {
        List<Curso> cursos = service.obterCursosPorTitulo(titulo);
        return listCursosToResponse(cursos);
    }

    private ResponseVO listCursosToResponse(List<Curso> cursos) {
        ResponseVO response = new ResponseVO();

        if (CollectionUtils.isNotEmpty(cursos)) {
            response.setStatusCode(OK);
            response.setData(cursos);
            return response;
        }

        response.setMessage(Utils.getMessage("response.cursos.nao.encontrado.por.parametro"));
        response.setStatusCode(RECORD_NOT_FOUND);
        return response;
    }

}
