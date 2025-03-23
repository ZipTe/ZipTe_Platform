package com.zipte.platform.server.domain.estate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Location {
    private String type;
    private List<Double> coordinates;

    public Double getLongitude() {
        return coordinates.get(0);
    }

    public Double getLatitude() {
        return coordinates.get(1);
    }
}
