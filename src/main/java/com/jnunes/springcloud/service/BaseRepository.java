package com.jnunes.springcloud.service;

import com.jnunes.springcloud.domain.EntityS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<T extends EntityS> extends JpaRepository<T, Long> {
}
