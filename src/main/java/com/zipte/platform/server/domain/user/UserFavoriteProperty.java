package com.zipte.platform.server.domain.user;

import com.zipte.platform.server.domain.BaseDomain;
import com.zipte.platform.server.domain.property.Property;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class UserFavoriteProperty extends BaseDomain {

    private Long id;

    private User user;

    private Property property;

}
