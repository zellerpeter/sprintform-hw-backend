package com.sprintform.hw.client.dto.error.validation;

import com.sprintform.hw.client.dto.error.ErrorResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Singular;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * @author peti
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@SuperBuilder
@Getter
public class ValidationErrorResponse extends ErrorResponse {

    @Singular
    List<FieldError> fieldErrors;

    @Singular
    List<String> errors;
}
