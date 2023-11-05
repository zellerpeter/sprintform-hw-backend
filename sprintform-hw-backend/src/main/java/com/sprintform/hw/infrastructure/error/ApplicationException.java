package com.sprintform.hw.infrastructure.error;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Exception that contains an error code.
 *
 * @author zellerpeter
 */
@RequiredArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApplicationException extends RuntimeException {

    ErrorCode errorCode;
}
