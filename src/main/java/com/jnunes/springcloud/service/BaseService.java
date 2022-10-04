package com.jnunes.springcloud.service;


import com.jnunes.springcloud.domain.EntityS;
import com.jnunes.springcloud.suport.response.ResponseVO;

public interface BaseService<S extends EntityS> {

    public ResponseVO save(S entity);

    public ResponseVO get(Long id);

    public ResponseVO delete(Long id);

    public ResponseVO update(S entity);

    public ResponseVO list(Long id);

}
