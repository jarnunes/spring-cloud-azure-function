package com.jnunes.springcloud.service;


import com.jnunes.springcloud.domain.EntityS;
import com.jnunes.springcloud.suport.response.ResponseVO;

import java.util.Optional;

public interface BaseService<S extends EntityS> {

    ResponseVO save(S entity);

    Optional<S> get(Long id);

    ResponseVO delete(Long id);

    ResponseVO update(S entity);

}
