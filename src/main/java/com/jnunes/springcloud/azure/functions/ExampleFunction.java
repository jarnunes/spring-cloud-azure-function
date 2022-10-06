package com.jnunes.springcloud.azure.functions;

import com.jnunes.springcloud.suport.response.ResponseVO;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Configuration
public class ExampleFunction {


    @Bean("HttpExample")
    public Function<Map<String, String>, ResponseVO> save() {
        return this::montarValores;

    }

    private ResponseVO montarValores(Map<String, String> mapa) {
        Map<String, Object> myMap = new HashMap<>();

        String nome = mapa.get("name").concat("Concatenado caralho");
        Integer idade = Optional.ofNullable(mapa.get("idade")).map(StringUtils::trimToNull)
                .map(NumberUtils::toInt).orElse(0);

        myMap.put("name", nome);
        myMap.put("idade", idade);
//        Integer idade = Integ;er.valueOf(mapa.get("idade"));
//        Integer idInicial = Integer.valueOf(mapa.get("idInicial"));
//        Integer idFinal = Integer.valueOf(mapa.get("idFinal"));
        return new ResponseVO("Segue exemplo", myMap);

    }


}

