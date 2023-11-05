package com.sprintform.hw.client.dto.error.validation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * Response for field validation errors.
 *
 * @author zellerpeter
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@SuperBuilder
@AllArgsConstructor
@Getter
public class FieldError {

    /**
     * Name of the field.
     */
    String field;

    /**
     * Description of the validation error.
     */
    String description;
}
