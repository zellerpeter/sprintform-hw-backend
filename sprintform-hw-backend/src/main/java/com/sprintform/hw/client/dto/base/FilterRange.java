package com.sprintform.hw.client.dto.base;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

/**
 * @author peti
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Getter
@Setter
@Jacksonized
public class FilterRange<T> {

    T from;

    T to;
}
