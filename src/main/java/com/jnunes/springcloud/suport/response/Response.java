package com.jnunes.springcloud.suport.response;

import com.jnunes.springcloud.suport.Utils;

public class Response {

    private Response() {
    }

    public static DetalheErro error() {
        return new DetalheErro();
    }


    public static ResponseVO success(Object data) {
        return SuccessResponse.of(data);
    }

    public class ErrorResponse extends BaseResponse{

        private ErrorResponse(Object data) {
            this.responseVO = new ResponseVO(null, data);
        }



        public ResponseVO notFound() {
            return new ResponseVO(Utils.getMessage("response.id.not.found"), null);
        }

    }

}
