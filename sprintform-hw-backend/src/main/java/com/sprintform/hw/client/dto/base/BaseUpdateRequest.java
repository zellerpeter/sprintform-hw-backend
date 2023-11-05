package com.sprintform.hw.client.dto.base;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

/**
 * Base request for update operation.
 *
 * @author zellerpeter
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@SuperBuilder
@Getter
public abstract class BaseUpdateRequest {
    @NotNull
    UUID id;
}
