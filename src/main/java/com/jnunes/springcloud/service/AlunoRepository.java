package com.jnunes.springcloud.service;

import com.jnunes.springcloud.domain.Aluno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends BaseRepository<Aluno> {

    @Query(" from Aluno al where al.id >= :idInicioReferencia and al.id <= :idFimReferencia ")
    List<Aluno> obterAlunosPorInicioFimReferenciaId(@Param("idInicioReferencia") Long idInicioReferencia,
        @Param("idFimReferencia") Long idFimReferencia);


    @Query(" from Aluno al " +
            " inner join al.cursos c " +
            " where UPPER(c.titulo) like CONCAT('%',UPPER(:tituloCurso),'%') " +
            " order by al.name ")
    List<Aluno> obterAlunosPorCurso(@Param("tituloCurso") String tituloCurso);

    @Query(" from Aluno al where UPPER(al.name) like CONCAT('%',UPPER(:nome),'%') " +
            " order by al.name ")
    List<Aluno> obterAlunosPorNome(@Param("nome") String nome);


}
