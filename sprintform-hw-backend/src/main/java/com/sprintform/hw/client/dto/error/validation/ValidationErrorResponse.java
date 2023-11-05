package com.sprintform.hw.client.dto.error.validation;

import com.sprintform.hw.client.dto.error.ErrorResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Singular;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * Response for validation errors.
 *
 * @author zellerpeter
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@SuperBuilder
@Getter
public class ValidationErrorResponse extends ErrorResponse {

    /**
     * Contains all field validation errors.
     */
    @Singular
    List<FieldError> fieldErrors;

    /**
     * Contains other errors, e.g.: from custom validation.
     */
    @Singular
    List<String> errors;
}
