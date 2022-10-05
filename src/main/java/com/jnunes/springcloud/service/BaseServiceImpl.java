package com.jnunes.springcloud.service;

import com.jnunes.springcloud.domain.EntityS;
import com.jnunes.springcloud.suport.response.ResponseVO;
import com.jnunes.springcloud.suport.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public abstract class BaseServiceImpl<S extends EntityS> implements BaseService<S> {

    @Autowired
    private BaseRepository<S> repository;

    @Override
    public ResponseVO save(S entity) {
        repository.save(entity);
        return SuccessResponse.of(entity).post();
    }

    @Override
    public ResponseVO get(Long id) {
        return repository.findById(id).map(it -> SuccessResponse.of(it).get()).orElseThrow(RuntimeException::new);
    }

    @Override
    public ResponseVO delete(Long id) {
        repository.deleteById(id);
        return SuccessResponse.of(true).delete();
    }

    @Override
    public ResponseVO update(S entity) {
        return Optional.of(repository.save(entity)).map(it -> SuccessResponse.of(it).put()).orElse(null);
    }

    @Override
    public ResponseVO list(Long id) {
        return Optional.ofNullable(id)
                .map(idAluno -> repository.findById(idAluno)).map(it -> SuccessResponse.of(it).get())
                .orElse(SuccessResponse.of(repository.findAll()).get());
    }


}
