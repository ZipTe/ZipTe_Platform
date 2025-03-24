package com.zipte.platform.server.domain.property;

import com.zipte.platform.server.domain.BaseDomain;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Property extends BaseDomain {

    private Long id;
    private Long ownerId;

    // 기존 아파트와 연관되는 변수
    private String kaptCode;

    private PropertyType type;
    private PropertyAddress address;
    private PropertySnippet snippet;
    private PropertyStatistic statistic;

    private long price;
    private boolean verified;

    // 생성자
    public static Property of(Long ownerId, PropertyType type, PropertyAddress address, PropertySnippet snippet, PropertyStatistic statistic, long price, String kaptCode) {
        return Property.builder()
                .ownerId(ownerId)
                .kaptCode(kaptCode)
                .type(type)
                .address(address)
                .snippet(snippet)
                .statistic(statistic)
                .price(price)
                .verified(false)
                .build();
    }

}
