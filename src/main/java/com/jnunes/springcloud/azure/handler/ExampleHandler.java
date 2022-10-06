package com.jnunes.springcloud.azure.handler;

import com.jnunes.springcloud.suport.Utils;
import com.jnunes.springcloud.suport.response.ResponseVO;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ExampleHandler extends FunctionInvoker<Map<String, String>, ResponseVO> {

//    @FunctionName("HttpExample")
//    public HttpResponseMessage run(
//            @HttpTrigger(
//                    name = "req",
//                    methods = {HttpMethod.GET, HttpMethod.POST},
//                    authLevel = AuthorizationLevel.ANONYMOUS)
//            HttpRequestMessage<Optional<String>> request,
//            final ExecutionContext context) {
//        context.getLogger().info("Java HTTP trigger processed a request.");
//
//        // Parse query parameter
//        final String query = request.getQueryParameters().get("name");
//        final String name = request.getBody().orElse(query);
//
//        if (name == null) {
//            return request.createResponseBuilder(HttpStatus.BAD_REQUEST)
//                    .body("Please pass a name on the query string or in the request body").build();
//        } else {
//            return request.createResponseBuilder(HttpStatus.OK).body("Hello, " + name).build();
//        }
//    }

    @FunctionName("HttpExample")
    public ResponseVO run(
            @HttpTrigger(
                    name = "req",
                    methods = {HttpMethod.GET, HttpMethod.POST},
                    authLevel = AuthorizationLevel.ANONYMOUS)
            HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

//        // Parse query parameter
        final String query = request.getQueryParameters().get("name");
        final String name = request.getBody().orElse(query);
//
//        return new ResponseVO(Utils.getMessage("response.id.not.found"), "DataMessage");

//        Map<String, String > mapa = new HashMap<>();
//        mapa.put("name", request.getQueryParameters().get("name"));
//        mapa.put("idade", request.getQueryParameters().get("idade"));
//        mapa.put("idInicial", request.getQueryParameters().get("idInicial"));
//        mapa.put("idFinal", request.getQueryParameters().get("idFinal"));
        return handleRequest(request.getQueryParameters(), context);

    }
}
