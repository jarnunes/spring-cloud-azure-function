package com.jnunes.springcloud.suport.response;


import com.jnunes.springcloud.suport.Utils;

public class SuccessResponse extends BaseResponse {
    private SuccessResponse(Object data) {
        this.responseVO = new ResponseVO(null, data);
    }

    public static ResponseVO of(Object data) {
        SuccessResponse successResponse = new SuccessResponse(data);
        successResponse.responseVO.setData(data);
        successResponse.responseVO.setMessage(Utils.getMessage("response.status.success.get"));
        return successResponse.responseVO;
    }

    public ResponseVO success() {
        this.responseVO.setMessage(Utils.getMessage("response.status.success.get"));
        return this.responseVO;
    }
}
