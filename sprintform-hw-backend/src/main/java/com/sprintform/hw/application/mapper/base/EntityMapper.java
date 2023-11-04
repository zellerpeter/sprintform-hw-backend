package com.sprintform.hw.application.mapper.base;

import com.sprintform.hw.client.dto.base.BaseUpdateRequest;
import org.mapstruct.Mapping;

/**
 * @author peti
 */
public interface EntityMapper <E, C, R, U extends BaseUpdateRequest, L> {

    E mapCreateRequestToEntity(final C request);

    R mapEntityToReadResponse(final E entity);

    E mapUpdateRequestToEntity(final U request);

    L mapEntityToListResponse(final E entity);
}
