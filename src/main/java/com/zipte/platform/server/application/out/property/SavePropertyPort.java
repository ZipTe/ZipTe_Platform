package com.zipte.platform.server.application.out.property;

import com.zipte.platform.server.domain.property.Property;

public interface SavePropertyPort {

    // 매물 등록하기
    Property saveProperty(Property property);

}
