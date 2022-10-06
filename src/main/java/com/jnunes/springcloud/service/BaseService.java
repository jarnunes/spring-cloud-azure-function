package com.jnunes.springcloud.service;


import com.jnunes.springcloud.domain.EntityS;
import com.jnunes.springcloud.suport.response.ResponseVO;

public interface BaseService<S extends EntityS> {

    ResponseVO save(S entity);

    ResponseVO get(Long id);

    ResponseVO delete(Long id);

    ResponseVO update(S entity);

}
