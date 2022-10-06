package com.jnunes.springcloud.azure.functions;

import com.jnunes.springcloud.domain.Curso;
import com.jnunes.springcloud.service.CursoServiceImpl;
import com.jnunes.springcloud.suport.response.ResponseVO;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
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
    public Function<Map<String, String>, ResponseVO> list() {
        return this::montarLista;
    }

    private ResponseVO montarLista(Map<String, String> mapa) {
        Map<String, Object> myMap = new HashMap<>();

        myMap.put("name", mapa.get("name").concat("Concatenado caralho"));
        myMap.put("idade", toIntOrNull(mapa.get("idade")));
        myMap.put("idInicial", toIntOrNull(mapa.get("idInicial")));
        myMap.put("idFinal", toIntOrNull(mapa.get("idFinal")));
        return new ResponseVO(null, 23, myMap, null);
    }

    private Integer toIntOrNull(String value) {
        return Optional.ofNullable(value).map(StringUtils::trimToNull)
                .map(this::getDigitos).map(Integer::parseInt).orElse(null);
    }

    private String getDigitos(String strValue) {
        return Optional.ofNullable(strValue)
                .map(str -> str.replaceAll("\\D", StringUtils.EMPTY)).orElse(null);
    }
}
