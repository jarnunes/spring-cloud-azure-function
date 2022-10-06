package com.jnunes.springcloud.azure.handler.utils;


import com.jnunes.springcloud.domain.Aluno;
import com.jnunes.springcloud.domain.Curso;
import com.microsoft.azure.functions.HttpRequestMessage;

import java.util.Optional;

public class HandlerUtils {

    private HandlerUtils() {
    }

    public static Aluno getAluno(HttpRequestMessage<Optional<Aluno>> request) {
        return request.getBody().orElse(null);
    }

    public static Curso getCurso(HttpRequestMessage<Optional<Curso>> request) {
        return request.getBody().orElse(null);
    }

    public static String getQueryParameters(HttpRequestMessage<Optional<Long>> request, String key) {
        return request.getQueryParameters().get(key);
    }
}
