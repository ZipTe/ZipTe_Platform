package com.zipte.platform.server.application.service;

import com.zipte.platform.server.application.in.favorite.FavoriteUseCase;
import com.zipte.platform.server.application.out.favorite.FavoritePort;
import com.zipte.platform.server.domain.favorite.Favorite;
import com.zipte.platform.server.domain.favorite.FavoriteType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FavoriteService implements FavoriteUseCase {

    private final FavoritePort favoritePort;

    @Override
    public Favorite createFavorite(Long userId, FavoriteType type, String code) {

        /// 유저가 존재하는지, 예외 처리

        /// 해당 코드가 존재하는지 예외 처리

        /// 객체 생성
        Favorite favorite = Favorite.of(userId, type, code);

        /// 저장하기
        return favoritePort.saveFavorite(favorite);
    }

    @Override
    public void removeFavorite(Long userId, Long favoriteId) {

        /// 유저가 존재하는지, 예외처리


        /// 해당 유저와 favoriteId가 관련이 있는지 예외처리


        /// 저장
        favoritePort.deleteFavorite(favoriteId);
    }

    @Override
    public List<String> getFavorite(Long userId) {
        return List.of();
    }
}
