package com.jnunes.springcloud.suport.response;


public class ErrorResponse extends BaseResponse {
    private ErrorResponse(String msg) {
        this.responseVO = new ResponseVO();
        this.responseVO.setMessage(msg);
    }

    public static ErrorResponse ofException(Exception e) {
        return new ErrorResponse(e.getMessage());
    }

    public static ErrorResponse of(String message){
        return new ErrorResponse(message);
    }

    public ErrorResponse setNotFoundStatusCode() {
        this.responseVO.setStatusCode(404);
        return this;
    }

    public ErrorResponse setInternalServerErrorStatusCode() {
        this.responseVO.setStatusCode(500);
        return this;
    }

    public ResponseVO build() {
        return this.responseVO;
    }


}
