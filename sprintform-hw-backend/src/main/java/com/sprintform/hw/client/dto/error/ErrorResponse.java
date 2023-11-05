package com.sprintform.hw.client.dto.error;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * Base response for errors.
 *
 * @author zellerpeter
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@SuperBuilder
@AllArgsConstructor
@Getter
public class ErrorResponse {

    /**
     * Error code.
     */
    int code;

    /**
     * Description of the error.
     */
    String description;
}
