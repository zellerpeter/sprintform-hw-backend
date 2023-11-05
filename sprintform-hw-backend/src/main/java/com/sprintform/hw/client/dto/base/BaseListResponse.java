package com.sprintform.hw.client.dto.base;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

/**
 * Base response for list operation.
 *
 * @author zellerpeter
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@SuperBuilder
@Getter
public abstract class BaseListResponse {
    UUID id;
}
