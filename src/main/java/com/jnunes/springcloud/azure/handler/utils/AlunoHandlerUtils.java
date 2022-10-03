package com.jnunes.springcloud.azure.handler.utils;


import com.jnunes.springcloud.domain.Aluno;
import com.microsoft.azure.functions.HttpRequestMessage;

import java.util.Optional;

public class AlunoHandlerUtils {

    private AlunoHandlerUtils() {
    }

    public static Aluno getAluno(HttpRequestMessage<Optional<Aluno>> request) {
        return request.getBody().orElse(null);
    }

    public static String getQueryParameters(HttpRequestMessage<Optional<Long>> request, String key) {
        return request.getQueryParameters().get(key);
    }
}
