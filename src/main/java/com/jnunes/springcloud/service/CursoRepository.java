package com.jnunes.springcloud.service;

import com.jnunes.springcloud.domain.Curso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CursoRepository extends BaseRepository<Curso> {

    @Query(" from Curso c where c.id >= :idInicioReferencia and c.id <= :idFimReferencia ")
    List<Curso> obterCursosPorInicioFimReferenciaId(@Param("idInicioReferencia") Long idInicioReferencia,
        @Param("idFimReferencia") Long idFimReferencia );

    @Query(" from Curso c where UPPER(c.titulo) like CONCAT('%',UPPER(:titulo),'%') " +
            " order by c.titulo ")
    List<Curso> obterCursosPorTitulo(@Param("titulo") String titulo);

    @Query(" from Curso c where c.dataInicio between :dataInicioReferencia and :dataFimReferencia  " +
           " order by c.titulo ")
    List<Curso> obterCursosPorDataInicioReferencia(@Param("dataInicioReferencia") LocalDate dataInicioReferencia,
        @Param("dataFimReferencia") LocalDate dataFimReferencia);

}
