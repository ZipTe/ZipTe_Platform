package com.zipte.platform.core.util;


import com.zipte.platform.server.domain.property.PropertyAddress;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressParser {

    public static PropertyAddress parseAddress(String streetAddress) {
        // 정규식 패턴
        Pattern pattern = Pattern.compile("(\\S+?시)?\\s?(\\S+?(구|군|시))?\\s?(\\S+?동)?");
        Matcher matcher = pattern.matcher(streetAddress);

        String city = null, district = null, dong = null;

        if (matcher.find()) {
            city = matcher.group(1);      // "성남시" or null
            district = matcher.group(2);  // "분당구" or null
            dong = matcher.group(4);      // "야탑동" or null
        }

        return PropertyAddress.builder()
                .dong(dong)
                .district(district)
                .city(city)
                .build();
    }

}
