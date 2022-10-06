package com.jnunes.springcloud.service;

import com.jnunes.springcloud.domain.EntityS;
import com.jnunes.springcloud.suport.response.ErrorResponse;
import com.jnunes.springcloud.suport.response.ResponseVO;
import com.jnunes.springcloud.suport.response.Success;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public abstract class BaseServiceImpl<S extends EntityS> implements BaseService<S> {

    @Autowired
    private BaseRepository<S> repository;

    @Override
    public ResponseVO save(S entity) {
        try {
            repository.save(entity);
            return Success.of(entity).post();
        } catch (Exception e) {
            return ErrorResponse.ofException(e).setInternalServerErrorStatusCode().build();
        }
    }

    @Override
    public ResponseVO get(Long id) {
        return repository.findById(id).map(it -> Success.of(it).get())
                .orElse(ErrorResponse.of("Nenhum registro encontrado para o id " + id)
                        .setNotFoundStatusCode().build());

    }

    @Override
    public ResponseVO delete(Long id) {
        try {
            repository.deleteById(id);
            return Success.of(true).delete();
        } catch (Exception e) {
            return ErrorResponse.ofException(e).setNotFoundStatusCode().build();
        }
    }

    @Override
    public ResponseVO update(S entity) {
        try {
            return Optional.of(repository.save(entity)).map(it -> Success.of(it).put()).orElse(null);
        } catch (Exception e) {
            return ErrorResponse.ofException(e).setInternalServerErrorStatusCode().build();
        }
    }

    @Override
    public ResponseVO list(Long id) {
        return Optional.ofNullable(id)
                .map(idAluno -> repository.findById(idAluno)).map(it -> Success.of(it).get())
                .orElse(Success.of(repository.findAll()).get());
    }


}
