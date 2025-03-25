package com.zipte.platform.server.adapter.in.web;

import com.zipte.platform.core.response.ApiResponse;
import com.zipte.platform.core.util.KafkaKeyGenerator;
import com.zipte.platform.server.adapter.in.web.dto.FavoriteRequest;
import com.zipte.platform.server.adapter.out.kafka.event.EventType;
import com.zipte.platform.server.adapter.out.kafka.event.FavoriteEvent;
import com.zipte.platform.server.application.in.favorite.FavoriteUseCase;
import com.zipte.platform.server.application.out.mq.ProducerPort;
import com.zipte.platform.server.domain.favorite.Favorite;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/favorite")
@RequiredArgsConstructor
public class FavoriteApi {

    private final FavoriteUseCase favoriteService;
    private final ProducerPort<FavoriteEvent> producer;

    @PostMapping()
    public ApiResponse<String> createFavorite(@RequestBody FavoriteRequest request) {

        /// 객체 생성
        Favorite favorite = favoriteService.createFavorite(request.getUserId(), request.getType(), request.getCode());

        /// Kafka 전송하기
        FavoriteEvent event = FavoriteEvent.from(EventType.ADD, favorite);
        producer.send(KafkaKeyGenerator.getFavorite(), event);

        return ApiResponse.ok("즐겨찾기가 정상적으로 추가되었습니다.");
    }


}
