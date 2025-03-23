package com.zipte.platform.server.adapter.in.web.dto;

import com.zipte.platform.server.domain.property.Property;
import com.zipte.platform.server.domain.property.PropertyType;
import com.zipte.platform.server.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PropertyDetailResponse {

    private Long id;
    private String ownerName;
    private PropertyType type;
    private long price;
    private boolean verified;

    private PropertySnippetResponse snippet;
    private PropertyStatisticsResponse statistics;

    public static PropertyDetailResponse from(Property property, User owner) {
        return PropertyDetailResponse.builder()
                .id(property.getId())
                .ownerName(owner.getUsername())
                .type(property.getType())
                .price(property.getPrice())
                .verified(property.isVerified())
                .snippet(PropertySnippetResponse.from(property.getSnippet(), property.getAddress()))
                .statistics(PropertyStatisticsResponse.from(property.getStatistic()))
                .build();
    }

}
