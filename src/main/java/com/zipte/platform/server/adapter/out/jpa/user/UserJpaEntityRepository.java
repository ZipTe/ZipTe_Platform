package com.zipte.platform.server.adapter.out.jpa.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaEntityRepository extends JpaRepository<UserJpaEntity, Long> {
}
