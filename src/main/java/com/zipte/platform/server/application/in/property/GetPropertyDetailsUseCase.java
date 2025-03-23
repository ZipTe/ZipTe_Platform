package com.zipte.platform.server.application.in.property;

import com.zipte.platform.server.adapter.in.web.dto.PropertyDetailResponse;

public interface GetPropertyDetailsUseCase {

    /*
        매물 상세정보 가져오기
     */

    PropertyDetailResponse getPropertyDetails(Long propertyId);


}
