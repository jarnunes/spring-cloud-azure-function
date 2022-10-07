package com.jnunes.springcloud.suport.response;


import com.jnunes.springcloud.suport.Utils;
import static com.jnunes.springcloud.azure.functions.consts.ConstsKeyMap.*;

public class ErrorResponse extends BaseResponse {
    private ErrorResponse(String msg) {
        this.responseVO = new ResponseVO();
        this.responseVO.setMessage(msg);
    }

    public static ErrorResponse ofException(Exception e) {
        return new ErrorResponse(e.getMessage());
    }

    public static ErrorResponse of(String message) {
        return new ErrorResponse(message);
    }

    public static ErrorResponse resourceIdNotFound(Long idReferencia) {
        ErrorResponse error = new ErrorResponse(
                Utils.getMessage("response.registro.nao.encontrado", ID_REFERENCIA, idReferencia));
        return error.setNotFoundStatusCode();
    }

    public static ErrorResponse resourceIdentifierNotFound(String identifier) {
        ErrorResponse error = new ErrorResponse(
                Utils.getMessage("response.registro.nao.encontrado", "identificador", identifier));
        return error.setNotFoundStatusCode();
    }

    public ErrorResponse setNotFoundStatusCode() {
        this.responseVO.setCode(404);
        return this;
    }

    public ErrorResponse setInternalServerErrorStatusCode() {
        this.responseVO.setCode(500);
        return this;
    }

    public ResponseVO build() {
        return this.responseVO;
    }


}
