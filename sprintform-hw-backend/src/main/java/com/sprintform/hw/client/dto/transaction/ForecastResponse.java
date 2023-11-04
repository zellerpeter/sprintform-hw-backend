package com.sprintform.hw.client.dto.transaction;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

/**
 * Aggregated statistics response.
 * @author peti
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Getter
@Jacksonized
public class ForecastResponse {

    /**
     * Forecast sum.
     */
    Double forecastSum;
}
