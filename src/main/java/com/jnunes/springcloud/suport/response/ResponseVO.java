package com.jnunes.springcloud.suport.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseVO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    private Integer code;
    private Object data;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Object> dataList;

    public ResponseVO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public ResponseVO(String message, List<Object> dataList) {
        this.message = message;
        this.dataList = dataList;
    }
}
