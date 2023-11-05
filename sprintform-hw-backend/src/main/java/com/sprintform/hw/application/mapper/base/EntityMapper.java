package com.sprintform.hw.application.mapper.base;

import com.sprintform.hw.client.dto.base.BaseUpdateRequest;
import org.mapstruct.Mapping;

/**
 * Responsible for mapping API requests and responses to/from the entity.
 * @author zellerpeter
 */
public interface EntityMapper <E, C, R, U extends BaseUpdateRequest, L> {

    /**
     * Create request to entity mapping.
     * @param request request
     * @return entity
     */
    E mapCreateRequestToEntity(final C request);

    /**
     * Entity to read response mapping.
     * @param entity entity
     * @return response
     */
    R mapEntityToReadResponse(final E entity);

    /**
     * Update request to entity mapping.
     * @param request request
     * @return entity
     */
    E mapUpdateRequestToEntity(final U request);

    /**
     * Entity to list response mapping.
     * @param entity entity
     * @return response
     */
    L mapEntityToListResponse(final E entity);
}
