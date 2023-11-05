package com.sprintform.hw.infrastructure.error;

import com.sprintform.hw.client.dto.error.ErrorResponse;
import com.sprintform.hw.client.dto.error.validation.ValidationErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author zellerpeter
 */
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ApplicationException.class)
    protected ResponseEntity<ErrorResponse> handleConflict(ApplicationException ex, WebRequest request) {
        final ErrorCode errorCode = ex.getErrorCode();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(errorCode.getCode(), errorCode.name()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatusCode status, final WebRequest request) {
        final ValidationErrorResponse.ValidationErrorResponseBuilder<?, ?> builder = ValidationErrorResponse.builder();

        builder.code(ErrorCode.VALIDATION_ERROR.getCode())
                .description("Validation error");

        for (FieldError fieldError : ex.getFieldErrors()) {
            builder.fieldError(new com.sprintform.hw.client.dto.error.validation.FieldError(fieldError.getField(), fieldError.getDefaultMessage()));
        }

        for (ObjectError error : ex.getGlobalErrors()) {
            builder.error(error.getDefaultMessage());
        }

        return ResponseEntity.status(BAD_REQUEST).body(builder.build());
    }
}
