package com.jnunes.springcloud.azure.functions;

import com.jnunes.springcloud.domain.EntityS;
import com.jnunes.springcloud.suport.Utils;
import com.jnunes.springcloud.suport.response.ResponseVO;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

import static com.jnunes.springcloud.suport.response.StatusCode.*;

public abstract class BaseFunction {

    protected ResponseVO listToResponse(List<? extends EntityS> entityS) {
        ResponseVO response = new ResponseVO();

        if (CollectionUtils.isNotEmpty(entityS)) {
            response.setCode(OK);
            response.setData(entityS);
            return response;
        }

        response.setMessage(Utils.getMessage("cursos.nao.encontrado.por.parametro"));
        response.setCode(RECORD_NOT_FOUND);
        return response;
    }

    protected ResponseVO responseToInvalidParameter(){
        ResponseVO response = new ResponseVO();
        response.setMessage(Utils.getMessage("response.cursos.lista.sem.parametros"));
        response.setCode(INVALID_PARAMETER);
        return response;
    }


}
