package com.zipte.platform.server.application.in.property;

import com.zipte.platform.server.adapter.in.web.dto.PropertyDetailResponse;
import com.zipte.platform.server.adapter.in.web.dto.PropertyRequest;

public interface CreatePropertyUseCase {

    /*
        교환할 매물정보 등록하기
     */

    PropertyDetailResponse create(PropertyRequest request); // 매물 생성



}
