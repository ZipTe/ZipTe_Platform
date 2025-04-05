package com.zipte.platform.server.adapter.in.web.dto;

import com.zipte.platform.server.domain.favorite.FavoriteType;
import lombok.Data;

@Data
public class FavoriteRequest {

    private Long userId;

    private FavoriteType type;

    private String code;
}
