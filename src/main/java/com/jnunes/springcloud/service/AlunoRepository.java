package com.jnunes.springcloud.service;

import com.jnunes.springcloud.domain.Aluno;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface AlunoRepository extends BaseRepository<Aluno> {
}
