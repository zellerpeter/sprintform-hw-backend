package com.sprintform.hw.infrastructure.error;

/**
 * @author peti
 */
public enum ErrorCode {
    INTERNAL_SERVER_ERROR,
    ENTITY_NOT_FOUND,
    VALIDATION_ERROR
    ;

    private static final int START_CODE = 1000;

    public int getCode() {
        return ordinal() + START_CODE;
    }
}
