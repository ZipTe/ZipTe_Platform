package com.zipte.platform.server.application.out.favorite;

import com.zipte.platform.server.domain.favorite.Favorite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FavoritePort {

    // 관심 목록 저장
    Favorite saveFavorite(Favorite favorite);

    // 관심 목록 해제
    void deleteFavorite(Long favoriteId);

    // 관심 목록 조회하기
    Page<Favorite> loadUserPreferences(Long userId, Pageable pageable);



}
