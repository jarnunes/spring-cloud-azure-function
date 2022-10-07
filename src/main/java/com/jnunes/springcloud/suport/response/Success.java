package com.jnunes.springcloud.suport.response;


import static com.jnunes.springcloud.suport.response.StatusCode.OK;

public class Success extends BaseResponse {
    private Success(Object data) {
        this.responseVO = new ResponseVO(null, data);
    }

    public static Success of(Object data) {
        Success successResponse = new Success(data);
        successResponse.responseVO.setData(data);
        return successResponse;
    }

    public ResponseVO statusOk() {
        this.responseVO.setCode(OK);
        return this.responseVO;
    }

}
