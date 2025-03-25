package com.zipte.platform.server.adapter.out.jpa.favorite;

import com.zipte.platform.server.adapter.out.jpa.BaseEntity;
import com.zipte.platform.server.domain.favorite.Favorite;
import com.zipte.platform.server.domain.favorite.FavoriteType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class FavoriteJpaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private FavoriteType type;

    private String kaptCode;

    private String regionCode;

    // from
    public static FavoriteJpaEntity from(Favorite entity) {
        return FavoriteJpaEntity.builder()
                .userId(entity.getUserId())
                .type(entity.getType())
                .kaptCode(entity.getKaptCode())
                .regionCode(entity.getRegionCode())
                .build();
    }

    // toDomain
    public Favorite toDomain() {
        return Favorite.builder()
                .id(id)
                .userId(userId)
                .type(type)
                .kaptCode(kaptCode)
                .regionCode(regionCode)
                .createdAt(getCreatedAt())
                .updatedAt(getUpdatedAt())
                .build();
    }

}
