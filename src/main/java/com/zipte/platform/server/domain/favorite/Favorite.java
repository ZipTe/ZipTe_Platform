package com.zipte.platform.server.domain.favorite;

import com.zipte.platform.server.domain.BaseDomain;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Favorite extends BaseDomain {

    private Long id;

    private Long userId;

    private FavoriteType type;

    private String kaptCode;

    private String regionCode;

    // 생성자
    public static Favorite of(Long userId, FavoriteType type, String code) {

        if (type == FavoriteType.APARTMENT) {
            return Favorite.builder()
                    .userId(userId)
                    .type(type)
                    .kaptCode(code)
                    .regionCode("")
                    .build();
        } else if (type == FavoriteType.REGION) {
            return Favorite.builder()
                    .userId(userId)
                    .type(type)
                    .kaptCode("")
                    .regionCode(code)
                    .build();
        } else {
            throw new IllegalArgumentException("관심 목록 생성 요청이 잘못 되었습니다.");
        }
    }


}
