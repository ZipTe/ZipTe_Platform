package com.zipte.platform.server.adapter.out.jpa;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // ✅ Auditing 기능 활성화
public abstract class BaseEntity {

    @CreatedDate
    private LocalDateTime createdAt; // 생성일 자동 설정

    @LastModifiedDate
    private LocalDateTime updatedAt; // 수정일 자동 설정
}

