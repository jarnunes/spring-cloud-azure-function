package com.jnunes.springcloud.suport.response;


import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
public class DetalheErro implements Serializable {
    private Integer statusCode;

    private String statusMessage;

    private String httpMethod;

    private String erro;

    private String detalhe;

    private String path;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private DetalheErro erro;

        Builder() {
            this.erro = new DetalheErro();
        }

        public Builder addStatus(HttpStatus status) {
            this.erro.statusCode = status.value();
            this.erro.statusMessage = status.getReasonPhrase();
            return this;
        }

        public Builder addHttpMethod(String method) {
            this.erro.httpMethod = method;
            return this;
        }

        public Builder addErro(String erro) {
            this.erro.erro = erro;
            return this;
        }

        public Builder addDetalhe(String detalhe) {
            this.erro.detalhe = detalhe;
            return this;
        }

        public Builder addPath(String path) {
            this.erro.path = path;
            return this;
        }

        public DetalheErro build() {
            return this.erro;
        }

    }
}
