package com.zipte.platform.server.domain;


import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@SuperBuilder
public abstract class BaseDomain {

    private Instant createdAt;
    private Instant updatedAt;

}
