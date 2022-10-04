package com.jnunes.springcloud.service;

import com.jnunes.springcloud.domain.EntityS;
import com.jnunes.springcloud.suport.response.Response;
import com.jnunes.springcloud.suport.response.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public abstract class BaseServiceImpl<S extends EntityS> implements BaseService<S> {

    @Autowired
    private BaseRepository<S> repository;

    @Override
    public ResponseVO save(S entity) {
        repository.save(entity);
        return Response.success(entity);
    }

    @Override
    public ResponseVO get(Long id) {
        return repository.findById(id).map(Response::success).orElseThrow(RuntimeException::new);
    }

    @Override
    public ResponseVO delete(Long id) {
        repository.deleteById(id);
        return Response.success(true);
    }

    @Override
    public ResponseVO update(S entity) {
        return Optional.of(repository.save(entity)).map(Response::success).orElse(null);
    }

    @Override
    public ResponseVO list(Long id) {
        return Optional.ofNullable(id)
                .map(idAluno -> repository.findById(idAluno)).map(Response::success)
                .orElse(Response.success(repository.findAll()));
    }


}
