package com.zipte.platform.server.adapter.out.jpa.property;

import com.zipte.platform.server.adapter.out.jpa.BaseEntity;
import com.zipte.platform.server.domain.property.Property;
import com.zipte.platform.server.domain.property.PropertyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class PropertyJpaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PropertyType type;

    private Long ownerId;

    @Embedded
    private PropertyAddressJpaEntity address;

    @Embedded
    private PropertySnippetJpaEntity snippet;

    @Embedded
    private PropertyStatisticJpaEntity statistic;

    private long price;

    private boolean verified;

    // 기존 아파트와 연관되는 변수
    private String kaptCode;

    // from
    public static PropertyJpaEntity from(Property property) {
        return PropertyJpaEntity.builder()
                .type(property.getType())
                .kaptCode(property.getKaptCode())
                .address(PropertyAddressJpaEntity.from(property.getAddress()))
                .ownerId(property.getOwnerId())
                .snippet(PropertySnippetJpaEntity.from(property.getSnippet()))
                .statistic(PropertyStatisticJpaEntity.from(property.getStatistic()))
                .price(property.getPrice())
                .verified(property.isVerified())
                .build();
    }

    // toDomain
    public Property toDomain(){
        return Property.builder()
                .id(id)
                .type(type)
                .kaptCode(kaptCode)
                .address(address.toDomain())
                .ownerId(ownerId)
                .snippet(snippet.toDomain())
                .statistic(statistic.toDomain())
                .price(price)
                .verified(verified)
                .build();
    }

}
