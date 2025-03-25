package com.zipte.platform.server.adapter.out.jpa.favorite;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteJpaRepository extends JpaRepository<FavoriteJpaEntity, Long> {

    Page<FavoriteJpaEntity> findByUserId(Long userId, Pageable pageable);

}
