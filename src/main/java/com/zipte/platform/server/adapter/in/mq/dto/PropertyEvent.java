package com.zipte.platform.server.adapter.in.mq.dto;

import com.zipte.platform.server.domain.property.Property;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class PropertyEvent {

    private PropertyEventType type;
    private String complexCode;
    private long price;
    private Instant occurredAt;

    public static PropertyEvent of(PropertyEventType type, Property property) {

        return PropertyEvent.builder()
                .type(type)
                .complexCode(property.getKaptCode())
                .price(property.getPrice())
                .occurredAt(property.getCreatedAt())
                .build();
    }

}
