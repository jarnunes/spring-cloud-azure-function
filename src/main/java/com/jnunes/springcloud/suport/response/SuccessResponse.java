package com.jnunes.springcloud.suport.response;


import com.jnunes.springcloud.suport.Utils;

public class SuccessResponse extends BaseResponse {
    private SuccessResponse(Object data) {
        this.responseVO = new ResponseVO(null, data);
    }

    public static SuccessResponse of(Object data) {
        SuccessResponse successResponse = new SuccessResponse(data);
        successResponse.responseVO.setData(data);
        return successResponse;
    }

    public ResponseVO get() {
        this.responseVO.setMessage(Utils.getMessage("response.status.success.get"));
        return this.responseVO;
    }

    public ResponseVO post() {
        this.responseVO.setMessage(Utils.getMessage("response.status.success.post"));
        return this.responseVO;
    }
    public ResponseVO put() {
        this.responseVO.setMessage(Utils.getMessage("response.status.success.put"));
        return this.responseVO;
    }

    public ResponseVO delete() {
        this.responseVO.setMessage(Utils.getMessage("response.status.success.delete"));
        return this.responseVO;
    }

}
