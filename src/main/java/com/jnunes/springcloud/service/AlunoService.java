package com.jnunes.springcloud.service;

import com.jnunes.springcloud.domain.Aluno;
import com.jnunes.springcloud.suport.response.ResponseVO;


public interface AlunoService {

    /**
     * @param aluno Aluno
     * @return ResponseVO
     */
    public ResponseVO save(Aluno aluno);

    public ResponseVO get(Long id);

    public ResponseVO delete(Long id);

    public ResponseVO update(Aluno aluno);

    public ResponseVO list(Long id);

}
