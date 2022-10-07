package com.jnunes.springcloud.azure.handler;

import com.jnunes.springcloud.azure.handler.utils.HandlerUtils;
import com.jnunes.springcloud.domain.Aluno;
import com.jnunes.springcloud.suport.response.ResponseVO;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.BindingName;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

import java.util.Optional;

public class AlunoHandler extends FunctionInvoker<Object, ResponseVO> {

    @FunctionName("alunoList")
    public ResponseVO list(
            @HttpTrigger(name = "request",
                    methods = {HttpMethod.GET},
                    authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<Long>> request,
            ExecutionContext context) {
        return handleRequest(request.getQueryParameters(), context);
    }

    @FunctionName("alunoSave")
    public ResponseVO save(
            @HttpTrigger(name = "alunoSaveRequest",
                    methods = {HttpMethod.POST},
                    authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<Aluno>> request,
            ExecutionContext context) {
        return handleRequest(HandlerUtils.getAluno(request), context);
    }

    @FunctionName("alunoGet")
    public ResponseVO get(
            @HttpTrigger(name = "alunoGetRequest",
                    methods = {HttpMethod.GET},
                    authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        return handleRequest(request.getQueryParameters(), context);
    }

    @FunctionName("alunoUpdate")
    public ResponseVO update(
            @HttpTrigger(name = "alunoUpdateRequest",
                    methods = {HttpMethod.PUT},
                    authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<Aluno>> request,
            ExecutionContext context) {
        return handleRequest(HandlerUtils.getAluno(request), context);
    }

    @FunctionName("alunoDelete")
    public ResponseVO delete(
            @HttpTrigger(name = "alunoGetRequest",
                    methods = {HttpMethod.DELETE},
                    authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            @BindingName("id") Long idAluno, ExecutionContext context) {
        return handleRequest(idAluno, context);
    }

}
