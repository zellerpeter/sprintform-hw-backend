package com.sprintform.hw.client.dto.base;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

/**
 * Used for filtering a field for a range of values.
 *
 * @author zellerpeter
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Getter
@Setter
@Jacksonized
public class FilterRange<T> {

    /**
     * Lower bound of the range.
     */
    T from;

    /**
     * Upper bound of the range.
     */
    T to;
}
