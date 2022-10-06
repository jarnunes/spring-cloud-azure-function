package com.jnunes.springcloud.azure.handler;

import com.jnunes.springcloud.azure.handler.utils.HandlerUtils;
import com.jnunes.springcloud.domain.Curso;
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

public class CursoHandler extends FunctionInvoker<Object, ResponseVO> {

    @FunctionName("cursoList")
    public ResponseVO list(
            @HttpTrigger(name = "request",
                    methods = {HttpMethod.GET},
                    authLevel = AuthorizationLevel.ANONYMOUS)
            HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
//        context.getLogger().info("Java HTTP trigger processed a request.");
        return handleRequest(request.getQueryParameters(), context);
    }


    @FunctionName("cursoSave")
    public ResponseVO save(
            @HttpTrigger(name = "cursoSaveRequest",
                    methods = {HttpMethod.POST},
                    authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<Curso>> request,
            ExecutionContext context) {
        return handleRequest(request.getBody().orElse(null), context);
    }


    @FunctionName("cursoGet")
    public ResponseVO get(
            @HttpTrigger(name = "cursoGetRequest", methods = {HttpMethod.GET},
                authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            @BindingName("id") Long idAluno, ExecutionContext context) {
        return handleRequest(idAluno, context);
    }

    @FunctionName("cursoUpdate")
    public ResponseVO update(
            @HttpTrigger(name = "cursoUpdateRequest", methods = {HttpMethod.PUT},
                authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<Curso>> request,
            ExecutionContext context) {
        return handleRequest(HandlerUtils.getCurso(request), context);
    }

    @FunctionName("cursoDelete")
    public ResponseVO delete(
            @HttpTrigger(name = "cursoGetRequest", methods = {HttpMethod.DELETE},
                authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            @BindingName("id") Long idAluno, ExecutionContext context) {
        return handleRequest(idAluno, context);
    }
}
